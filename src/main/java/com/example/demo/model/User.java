package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String fullname;

    @Column(unique = true)
    private String email;

    private String password;

    private String role = "USER";

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
}
