package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionService(TicketRepository ticketRepository,
                                     DuplicateDetectionLogRepository logRepository) {
        this.ticketRepository = ticketRepository;
        this.logRepository = logRepository;
    }

    public void runDetection(Long ticketId) {
        Ticket newTicket = ticketRepository.findById(ticketId).orElseThrow();
        List<Ticket> tickets = ticketRepository.findAll();

        for (Ticket t : tickets) {
            if (!t.getId().equals(ticketId)) {
                double score = TextSimilarityUtil.similarity(
                        newTicket.getDescription(), t.getDescription());

                if (score >= 0.5) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog();
                    log.setTicket(newTicket);
                    log.setMatchedTicket(t);
                    log.setMatchScore(score);
                    logRepository.save(log);
                }
            }
        }
    }
}
