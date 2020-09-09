package com.codeclan.techconnect.AirlineLab;

import com.codeclan.techconnect.AirlineLab.models.Bag;
import com.codeclan.techconnect.AirlineLab.models.Passenger;
import com.codeclan.techconnect.AirlineLab.models.Plane;
import com.codeclan.techconnect.AirlineLab.repositories.BagRepository;
import com.codeclan.techconnect.AirlineLab.repositories.PassengerRepository;
import com.codeclan.techconnect.AirlineLab.repositories.PlaneRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AirlineLabApplicationTests {

	@Autowired
	BagRepository bagRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	PlaneRepository planeRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void canFindPassengersBags() {
		List<Bag> foundBags = bagRepository.findByPassengerId(1L);
		assertEquals(2, foundBags.size());
	}

	@Test
	public void canFindPlanePassengers() {
		List<Passenger> foundPassengers = passengerRepository.findByPlaneId(1L);
		assertEquals(4, foundPassengers.size());
	}

	@Test
	public void canFindBagsOnAPlane() {
		List<Bag> foundBags = bagRepository.findByPassengerPlaneId(1L);
		assertEquals(7, foundBags.size());
	}

	@Test
	public void canCheckPlaneCapacity() {
		Plane plane = planeRepository.getOne(1L);
		assertEquals(4, plane.checkCapacity());
	}

	@Test
	public void canCheckTotalBaggageWeight() {
		Plane plane = planeRepository.getOne(1L);
		assertEquals(114, plane.checkWeightOfBagsOnBoard(), 0);
	}

}
