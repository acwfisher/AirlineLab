package com.codeclan.techconnect.AirlineLab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "passenger")
    @JsonIgnoreProperties("passenger")
    private List<Bag> bags;

    @ManyToOne
    @JsonIgnoreProperties("passengers")
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;

    public Passenger(String name, Plane plane) {
        this.name = name;
        this.plane = plane;
        this.bags = new ArrayList<>();
    }

    public Passenger() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bag> getBags() {
        return bags;
    }

    public void setBags(List<Bag> bags) {
        this.bags = bags;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

}
