package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepository,
            DuplicateRuleRepository ruleRepository,
            DuplicateDetectionLogRepository logRepository) {

        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket baseTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new NotFoundException("Ticket not found"));

        List<DuplicateDetectionLog> logs = new ArrayList<>();
        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");

        for (DuplicateRule rule : ruleRepository.findAll()) {
            for (Ticket ticket : openTickets) {

                if (ticket.getId().equals(baseTicket.getId())) continue;

                double score = 0.0;

                if ("EXACT_MATCH".equals(rule.getMatchType())
                        && baseTicket.getSubject().equalsIgnoreCase(ticket.getSubject())) {
                    score = 1.0;
                }

                if ("SIMILARITY".equals(rule.getMatchType())) {
                    score = TextSimilarityUtil.similarity(
                            baseTicket.getDescription(),
                            ticket.getDescription()
                    );
                }

                if (score >= rule.getThreshold()) {
                    logs.add(
                            logRepository.save(
                                    new DuplicateDetectionLog(baseTicket, ticket, score)
                            )
                    );
                }
            }
        }
        return logs;
    }

    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Log not found"));
    }
}
