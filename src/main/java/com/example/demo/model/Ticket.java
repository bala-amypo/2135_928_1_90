package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private TicketCategory category;

    private String subject;

    @Column(length = 1000)
    private String description;

    private String status;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "ticket")
    private List<DuplicateDetectionLog> baseLogs;

    @OneToMany(mappedBy = "matchedTicket")
    private List<DuplicateDetectionLog> matchedLogs;

    public Ticket() {
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "OPEN";
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public User getUser() { return user; }
    public TicketCategory getCategory() { return category; }
    public String getSubject() { return subject; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setCategory(TicketCategory category) { this.category = category; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
}
