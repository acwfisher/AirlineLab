package com.codeclan.techconnect.AirlineLab.components;

import com.codeclan.techconnect.AirlineLab.models.Bag;
import com.codeclan.techconnect.AirlineLab.models.Passenger;
import com.codeclan.techconnect.AirlineLab.models.Plane;
import com.codeclan.techconnect.AirlineLab.repositories.BagRepository;
import com.codeclan.techconnect.AirlineLab.repositories.PassengerRepository;
import com.codeclan.techconnect.AirlineLab.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BagRepository bagRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PlaneRepository planeRepository;

    public void run(ApplicationArguments args) {

        // Planes
        Plane paris = new Plane("Paris", "EZY6883", 215, 4500);
        planeRepository.save(paris);

        Plane toronto = new Plane("Toronto", "AC849", 416, 9000);
        planeRepository.save(toronto);

        Plane beijing = new Plane("Beijing", "CA938", 555, 12000);
        planeRepository.save(beijing);

        // Passengers
        Passenger gwen = new Passenger("Gwen Jones", paris);
        passengerRepository.save(gwen);

        Passenger daniel = new Passenger("Daniel Arthur", toronto);
        passengerRepository.save(daniel);

        Passenger sara = new Passenger("Sara Smith", beijing);
        passengerRepository.save(sara);

        Passenger yakub = new Passenger("Yakub Voll", toronto);
        passengerRepository.save(yakub);

        Passenger jara = new Passenger("Jara Hussein", paris);
        passengerRepository.save(jara);

        Passenger john = new Passenger("John Graham", toronto);
        passengerRepository.save(john);

        Passenger natalie = new Passenger("Natalie De Ruyn", paris);
        passengerRepository.save(natalie);

        Passenger vanya = new Passenger("Vanya Kulachenkov", beijing);
        passengerRepository.save(vanya);

        Passenger tien = new Passenger("Tien Teoh", beijing);
        passengerRepository.save(tien);

        Passenger tony = new Passenger("Tony Hunter", paris);
        passengerRepository.save(tony);

        Passenger amira = new Passenger("Amira Butt", beijing);
        passengerRepository.save(amira);

        Passenger ashok = new Passenger("Ashok Singh", toronto);
        passengerRepository.save(ashok);

        // Bags
        Bag bag1 = new Bag(21, gwen);
        bagRepository.save(bag1);

        Bag bag2 = new Bag(15, gwen);
        bagRepository.save(bag2);

        Bag bag3 = new Bag(20, daniel);
        bagRepository.save(bag3);

        Bag bag4 = new Bag(18, sara);
        bagRepository.save(bag4);

        Bag bag5 = new Bag(11, yakub);
        bagRepository.save(bag5);

        Bag bag6 = new Bag(16, yakub);
        bagRepository.save(bag6);

        Bag bag7 = new Bag(8, jara);
        bagRepository.save(bag7);

        Bag bag8 = new Bag(21, jara);
        bagRepository.save(bag8);

        Bag bag9 = new Bag(23, john);
        bagRepository.save(bag9);

        Bag bag10 = new Bag(22, natalie);
        bagRepository.save(bag10);

        Bag bag11 = new Bag(10, natalie);
        bagRepository.save(bag11);

        Bag bag12 = new Bag(23, vanya);
        bagRepository.save(bag12);

        Bag bag13 = new Bag(21, vanya);
        bagRepository.save(bag13);

        Bag bag14 = new Bag(18, tien);
        bagRepository.save(bag14);

        Bag bag15 = new Bag(7, tien);
        bagRepository.save(bag15);

        Bag bag16 = new Bag(17, tony);
        bagRepository.save(bag16);

        Bag bag17 = new Bag(19, amira);
        bagRepository.save(bag17);

        Bag bag18 = new Bag(14, amira);
        bagRepository.save(bag18);

        Bag bag19 = new Bag(18, ashok);
        bagRepository.save(bag19);

        Bag bag20 = new Bag(12, ashok);
        bagRepository.save(bag20);

    }
}
