package com.codeclan.techconnect.AirlineLab.repositories;

import com.codeclan.techconnect.AirlineLab.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    // Find all the passengers on a plane
    List<Passenger> findByPlaneId(long id);
}
