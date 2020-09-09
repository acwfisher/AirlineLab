package com.codeclan.techconnect.AirlineLab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String destination;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column
    private int capacity;

    @Column(name = "max_weight")
    private double maxWeight;

    @OneToMany(mappedBy = "plane")
    @JsonIgnoreProperties("plane")
    private List<Passenger> passengers;

    public Plane(String destination, String flightNumber, int capacity, double maxWeight) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.maxWeight = maxWeight;
        this.passengers = new ArrayList<>();
    }

    public Plane() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    // Add method to check how many passengers are on board
    public int checkCapacity() {
        return this.getPassengers().size();
    }

    // Add method to check the weight of bags on board
    public double checkWeightOfBagsOnBoard() {
        double totalBaggageWeight = 0;
        for (Passenger passenger : passengers) {
            List<Bag> passengerBaggage = passenger.getBags();
            for (Bag bag : passengerBaggage) {
                totalBaggageWeight += bag.getWeight();
            }
        } return totalBaggageWeight;
    }


}
