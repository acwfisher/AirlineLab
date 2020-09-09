package com.codeclan.techconnect.AirlineLab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bags")
public class Bag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double weight;

    @ManyToOne
    @JsonIgnoreProperties("bags")
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    public Bag(double weight, Passenger passenger) {
        this.weight = weight;
        this.passenger = passenger;
    }

    public Bag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }


}
