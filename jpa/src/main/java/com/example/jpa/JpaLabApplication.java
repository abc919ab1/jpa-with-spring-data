package com.example.jpa;

import com.example.jpa.model.Customer;
import com.example.jpa.model.CustomerStatus;
import com.example.jpa.model.Flight;
import com.example.jpa.model.FlightBooking;
import com.example.jpa.repository.CustomerRepository;
import com.example.jpa.repository.FlightRepository;
import com.example.jpa.repository.FlightBookingRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLabApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepo,
                          FlightRepository flightRepo,
                          FlightBookingRepository bookingRepo) {
        return args -> {
            // Customers
            Customer alice = customerRepo.save(new Customer("Alice", CustomerStatus.GOLD, 120000));
            Customer bob = customerRepo.save(new Customer("Bob", CustomerStatus.SILVER, 50000));
            Customer charlie = customerRepo.save(new Customer("Charlie", CustomerStatus.NONE, 10000));

            // Flights
            Flight flight1 = flightRepo.save(new Flight("AB123", "Boeing 747", 300, 400));
            Flight flight2 = flightRepo.save(new Flight("CD456", "Airbus A320", 200, 300));
            Flight flight3 = flightRepo.save(new Flight("EF789", "Boeing 737", 150, 200));

            // Bookings
            bookingRepo.save(new FlightBooking(alice.getId(), flight1.getId()));
            bookingRepo.save(new FlightBooking(bob.getId(), flight2.getId()));
            bookingRepo.save(new FlightBooking(charlie.getId(), flight3.getId()));
        };
    }
}
