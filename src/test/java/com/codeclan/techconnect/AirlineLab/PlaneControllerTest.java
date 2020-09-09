package com.codeclan.techconnect.AirlineLab;

import com.codeclan.techconnect.AirlineLab.models.Passenger;
import com.codeclan.techconnect.AirlineLab.models.Plane;
import com.codeclan.techconnect.AirlineLab.repositories.PassengerRepository;
import com.codeclan.techconnect.AirlineLab.repositories.PlaneRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {AirlineLabApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class PlaneControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    PlaneRepository planeRepository;
    @Autowired
    PassengerRepository passengerRepository;

    @Test
    public void canGetAllPlanesRoute() {
        // 1. Use restTemplate to make a GET request to /planes
        ResponseEntity<Plane[]> response = restTemplate.getForEntity("/planes/", Plane[].class);
        // 2. Take the response from this and store it in a variable of type Passenger[]
        Plane[] planes = response.getBody();
        // 3. Assert that the first passenger that comes back has correct name
        assertEquals("Paris", planes[0].getDestination());
    }

    @Test
    public void canPostPlane() {
        // Create a new Plane object (no ID - doesn't exist in DB)
        Plane plane = new Plane("Barcelona", "BA474", 215, 4500);
        // Create an HttpEntity object (payload)
        HttpEntity<Plane> requestPayload = new HttpEntity<>(plane);
        // POST the entity to "/planes/" - this will return a response
        ResponseEntity<Plane> response = restTemplate.postForEntity("/planes/", requestPayload, Plane.class);
        // assert that response has status code 201 (created)
        assertEquals(201, response.getStatusCodeValue());
        // assert that the plane exists in DB
        Long planeId = response.getBody().getId();
        Plane foundPlane = planeRepository.findById(planeId).get();
        assertEquals("Barcelona", foundPlane.getDestination());
    }
}