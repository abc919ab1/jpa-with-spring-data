package com.example.jpa.repository;

import com.example.jpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
    List<FlightBooking> findByCustomerId(Long customerId);
}
