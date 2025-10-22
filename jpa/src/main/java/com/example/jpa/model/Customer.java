package com.example.jpa.model;

import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    private Integer totalMiles;

    public Customer() {}

    public Customer(String name, CustomerStatus status, Integer totalMiles) {
        this.name = name;
        this.status = status;
        this.totalMiles = totalMiles;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public CustomerStatus getStatus() { return status; }
    public void setStatus(CustomerStatus status) { this.status = status; }
    public Integer getTotalMiles() { return totalMiles; }
    public void setTotalMiles(Integer totalMiles) { this.totalMiles = totalMiles; }
}
