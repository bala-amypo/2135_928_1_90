package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_rules")
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String matchType;

    private Double threshold;

    private LocalDateTime createdAt;

    public DuplicateRule() {
    }

    public DuplicateRule(String ruleName, String matchType, Double threshold) {
        this.ruleName = ruleName;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getRuleName() { return ruleName; }
    public String getMatchType() { return matchType; }
    public Double getThreshold() { return threshold; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public void setMatchType(String matchType) { this.matchType = matchType; }
    public void setThreshold(Double threshold) { this.threshold = threshold; }
}
