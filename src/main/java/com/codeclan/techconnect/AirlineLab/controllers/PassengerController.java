package com.codeclan.techconnect.AirlineLab.controllers;

import com.codeclan.techconnect.AirlineLab.models.Passenger;
import com.codeclan.techconnect.AirlineLab.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PassengerController {

    @Autowired
    PassengerRepository passengerRepository;

    @GetMapping(value = "/passengers")
    public ResponseEntity<List<Passenger>> getAllPassenger() {
        return new ResponseEntity<>(passengerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/passengers/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id) {
        Optional<Passenger> foundPassenger = passengerRepository.findById(id);

        if(foundPassenger.isPresent()) {
            return new ResponseEntity<>(foundPassenger, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(foundPassenger, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/passengers")
    public ResponseEntity<Passenger> postPassenger(@RequestBody Passenger passenger) {
        passengerRepository.save(passenger);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }
}
