package com.codeclan.techconnect.AirlineLab;

import com.codeclan.techconnect.AirlineLab.models.Bag;
import com.codeclan.techconnect.AirlineLab.models.Passenger;
import com.codeclan.techconnect.AirlineLab.repositories.BagRepository;
import com.codeclan.techconnect.AirlineLab.repositories.PassengerRepository;
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
public class BagControllerTest {
        @Autowired
        TestRestTemplate restTemplate;
        @Autowired
        PassengerRepository passengerRepository;
        @Autowired
        BagRepository bagRepository;

        @Test
        public void canGetAllBagsRoute() {
            // 1. Use restTemplate to make a GET request to /bags
            ResponseEntity<Bag[]> response = restTemplate.getForEntity("/bags/", Bag[].class);
            // 2. Take the response from this and store it in a variable of type Bag[]
            Bag[] bags = response.getBody();
            // 3. Assert that the first bag that comes back has correct weight
            assertEquals(21, bags[0].getWeight());
        }

        @Test
        public void canPostBag() {
            // Get a Passenger object that exists in DB
            Passenger passenger = passengerRepository.findById(1L).get();
            // Create a new Bag object (no ID - doesn't exist in DB)
            Bag bag = new Bag(13, passenger);
            // Create an HttpEntity object (payload)
            HttpEntity<Bag> requestPayload = new HttpEntity<>(bag);
            // POST the entity to "/bags/" - this will return a response
            ResponseEntity<Bag> response = restTemplate.postForEntity("/bags/", requestPayload, Bag.class);
            // assert that response has status code 201 (created)
            assertEquals(201, response.getStatusCodeValue());
            // assert that the bag exists in DB
            Long bagId = response.getBody().getId();
            Bag foundBag = bagRepository.findById(bagId).get();
            assertEquals(13, foundBag.getWeight());
        }
}
