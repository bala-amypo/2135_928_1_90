package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketRepository repo;

    public TicketController(TicketRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Ticket> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Ticket save(@RequestBody Ticket ticket) {
        return repo.save(ticket);
    }
}
