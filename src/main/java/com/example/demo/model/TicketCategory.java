package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ticket_categories")
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoryName;

    private String description;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "category")
    private List<Ticket> tickets;

    public TicketCategory() {
    }

    public TicketCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setDescription(String description) { this.description = description; }
}
