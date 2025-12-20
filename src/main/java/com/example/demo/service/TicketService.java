package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final DuplicateDetectionService detectionService;

    public TicketService(TicketRepository ticketRepository,
                         DuplicateDetectionService detectionService) {
        this.ticketRepository = ticketRepository;
        this.detectionService = detectionService;
    }

    public Ticket createTicket(Ticket ticket) {
        Ticket saved = ticketRepository.save(ticket);
        detectionService.runDetection(saved.getId());
        return saved;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
