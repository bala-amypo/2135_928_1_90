package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_logs")
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "matched_ticket_id")
    private Ticket matchedTicket;

    private Double matchScore;

    private LocalDateTime detectedAt;

    public DuplicateDetectionLog() {
    }

    public DuplicateDetectionLog(Ticket ticket, Ticket matchedTicket, Double matchScore) {
        this.ticket = ticket;
        this.matchedTicket = matchedTicket;
        this.matchScore = matchScore;
    }

    @PrePersist
    public void prePersist() {
        this.detectedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public Ticket getTicket() { return ticket; }
    public Ticket getMatchedTicket() { return matchedTicket; }
    public Double getMatchScore() { return matchScore; }
    public LocalDateTime getDetectedAt() { return detectedAt; }

    public void setId(Long id) { this.id = id; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public void setMatchedTicket(Ticket matchedTicket) { this.matchedTicket = matchedTicket; }
    public void setMatchScore(Double matchScore) { this.matchScore = matchScore; }
}
