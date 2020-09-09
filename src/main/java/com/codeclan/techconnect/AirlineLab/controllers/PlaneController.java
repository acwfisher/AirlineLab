package com.codeclan.techconnect.AirlineLab.controllers;

import com.codeclan.techconnect.AirlineLab.models.Plane;
import com.codeclan.techconnect.AirlineLab.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlaneController {

    @Autowired
    PlaneRepository planeRepository;

    @GetMapping(value = "/planes")
    public ResponseEntity<List<Plane>> getAllPlanes() {
        return new ResponseEntity<>(planeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/planes/{id}")
    public ResponseEntity<Optional<Plane>> getPlane(@PathVariable Long id) {
        Optional<Plane> foundPlane = planeRepository.findById(id);

        if(foundPlane.isPresent()) {
            return new ResponseEntity<>(foundPlane, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(foundPlane, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/planes")
    public ResponseEntity<Plane> postPlane(@RequestBody Plane plane) {
        planeRepository.save(plane);
        return new ResponseEntity<>(plane, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/planes/{id}")
    public ResponseEntity<Optional<Plane>> deletePlane(@PathVariable Long id) {
        Optional<Plane> foundPlane = planeRepository.findById(id);

        if(foundPlane.isPresent()) {
            planeRepository.deleteById(id);
            return new ResponseEntity<>(foundPlane, HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(foundPlane, HttpStatus.NOT_FOUND);
        }
    }
}
