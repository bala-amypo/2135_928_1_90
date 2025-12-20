package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class DuplicateRule {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String matchType;
    private Double threshold;

    private LocalDateTime createdAt = LocalDateTime.now();
}
