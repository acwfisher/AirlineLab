package com.codeclan.techconnect.AirlineLab.controllers;

import com.codeclan.techconnect.AirlineLab.models.Bag;
import com.codeclan.techconnect.AirlineLab.repositories.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BagController {

    @Autowired
    BagRepository bagRepository;

    @GetMapping(value = "/bags")
    public ResponseEntity<List<Bag>> getAllBags() {
        return new ResponseEntity<>(bagRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bags/{id}")
    public ResponseEntity<Optional<Bag>> getBag(@PathVariable Long id) {
        Optional<Bag> foundBag = bagRepository.findById(id);

        if(foundBag.isPresent()) {
            return new ResponseEntity<>(foundBag, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(foundBag, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/bags")
    public ResponseEntity<Bag> postBag(@RequestBody Bag bag) {
        bagRepository.save(bag);
        return new ResponseEntity<>(bag, HttpStatus.CREATED);
    }
}
