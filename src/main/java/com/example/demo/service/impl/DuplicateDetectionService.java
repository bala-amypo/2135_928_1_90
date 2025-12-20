package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

   
    public void detectDuplicates(Ticket newTicket) {

        List<Ticket> existingTickets = ticketRepository.findAll();

        for (Ticket oldTicket : existingTickets) {

            
            if (oldTicket.getId().equals(newTicket.getId())) {
                continue;
            }

            
            double score = TextSimilarityUtil.similarity(
                    newTicket.getDescription(),
                    oldTicket.getDescription()
            );

            // Threshold check (0.5 as per requirement)
            if (score >= 0.5) {

                DuplicateDetectionLog log = new DuplicateDetectionLog();
                log.setTicket(newTicket);
                log.setMatchedTicket(oldTicket);
                log.setMatchScore(score);
                log.setDetectedAt(LocalDateTime.now());

                logRepository.save(log);
            }
        }
    }

    
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }

   
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findAll()
                .stream()
                .filter(log -> log.getTicket().getId().equals(ticketId))
                .toList();
    }
}