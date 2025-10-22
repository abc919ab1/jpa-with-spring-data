package com.example.jpa.repository;

import com.example.jpa.model.Customer;
import com.example.jpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByStatus(CustomerStatus status);
}
