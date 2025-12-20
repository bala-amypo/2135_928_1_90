package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Ticket matchedTicket;

    private Double matchScore;

    private LocalDateTime detectedAt = LocalDateTime.now();
}
