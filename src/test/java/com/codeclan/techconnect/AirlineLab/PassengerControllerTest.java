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
public class PassengerControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    PlaneRepository planeRepository;

    @Test
    public void canGetAllPassengersRoute() {
        // 1. Use restTemplate to make a GET request to /passengers
        ResponseEntity<Passenger[]> response = restTemplate.getForEntity("/passengers/", Passenger[].class);
        // 2. Take the response from this and store it in a variable of type Passenger[]
        Passenger[] passengers = response.getBody();
        // 3. Assert that the first passenger that comes back has correct name
        assertEquals("Gwen Jones", passengers[0].getName());
    }

    @Test
    public void canPostPassenger() {
        // Get a Plane object that exists in DB
        Plane plane = planeRepository.findById(1L).get();
        // Create a new Passenger object (no ID - doesn't exist in DB)
        Passenger passenger = new Passenger("Anna Stevens", plane);
        // Create an HttpEntity object (payload)
        HttpEntity<Passenger> requestPayload = new HttpEntity<>(passenger);
        // POST the entity to "/pirates/" - this will return a response
        ResponseEntity<Passenger> response = restTemplate.postForEntity("/passengers/", requestPayload, Passenger.class);
        // assert that response has status code 201 (created)
        assertEquals(201, response.getStatusCodeValue());
        // assert that the passenger exists in DB
        Long passengerId = response.getBody().getId();
        Passenger foundPassenger = passengerRepository.findById(passengerId).get();
        assertEquals("Anna Stevens", foundPassenger.getName());
    }
}
