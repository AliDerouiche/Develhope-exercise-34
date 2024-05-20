package com.example.demo3.repositories;


import com.example.demo3.entities.Flight;
import com.example.demo3.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(FlightStatus flightStatus);
}