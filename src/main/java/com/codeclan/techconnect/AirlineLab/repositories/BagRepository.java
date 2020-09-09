package com.codeclan.techconnect.AirlineLab.repositories;

import com.codeclan.techconnect.AirlineLab.models.Bag;
import com.codeclan.techconnect.AirlineLab.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BagRepository extends JpaRepository<Bag, Long> {

    // Find a passenger's bags
    List<Bag> findByPassengerId(long id);

    // Find all the bags which have been loaded on to a plane
    List<Bag> findByPassengerPlaneId(long id);

}
