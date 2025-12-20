package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final DuplicateDetectionService duplicateDetectionService;

    // ✅ Constructor Injection (as required)
    public TicketService(TicketRepository ticketRepository,
                         DuplicateDetectionService duplicateDetectionService) {
        this.ticketRepository = ticketRepository;
        this.duplicateDetectionService = duplicateDetectionService;
    }

    // Create Ticket
    public Ticket createTicket(Ticket ticket) {
        ticket.setCreatedAt(LocalDateTime.now());
        Ticket savedTicket = ticketRepository.save(ticket);

        // Run duplicate detection after saving
        duplicateDetectionService.detectDuplicates(savedTicket);

        return savedTicket;
    }

    // Get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get ticket by id
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    // Get tickets by category
    public List<Ticket> getTicketsByCategory(Long categoryId) {
        return ticketRepository.findByCategoryId(categoryId);
    }
}