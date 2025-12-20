package com.example.demo.serviceImpl;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;

    public DuplicateDetectionServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public boolean isDuplicateTicket(Ticket ticket) {
        return ticketRepository.findAll()
                .stream()
                .anyMatch(t ->
                        t.getTitle().equalsIgnoreCase(ticket.getTitle()) &&
                        t.getDescription().equalsIgnoreCase(ticket.getDescription())
                );
    }
}
