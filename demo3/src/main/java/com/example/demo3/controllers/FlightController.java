package com.example.demo3.controllers;


import com.example.demo3.entities.Flight;
import com.example.demo3.enums.FlightStatus;
import com.example.demo3.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/getAll")
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/generateRandom")
    public void generateFlights() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription(RandomStringUtils.randomAlphabetic(10));
            flight.setFromAirport(RandomStringUtils.randomAlphabetic(3));
            flight.setToAirport(RandomStringUtils.randomAlphabetic(3));
            flight.setStatus(FlightStatus.ONTIME);
            flightRepository.save(flight);
        }
    }
}