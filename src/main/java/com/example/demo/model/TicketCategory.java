package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class TicketCategory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String categoryName;

    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();
}
