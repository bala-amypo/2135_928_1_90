package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DuplicateDetectionService;
import com.example.demo.util.TextSimilarityUtil;

import java.util.ArrayList;
import java.util.List;

public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final TicketRepository ticketRepository;
    private final DuplicateRuleRepository ruleRepository;
    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(
            TicketRepository ticketRepository,
            DuplicateRuleRepository ruleRepository,
            DuplicateDetectionLogRepository logRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {

        Ticket baseTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found"));

        List<Ticket> openTickets = ticketRepository.findByStatus("OPEN");
        List<DuplicateRule> rules = ruleRepository.findAll();

        List<DuplicateDetectionLog> logs = new ArrayList<>();

        for (Ticket t : openTickets) {
            if (t.getId().equals(ticketId)) continue;

            for (DuplicateRule rule : rules) {
                double score = TextSimilarityUtil.similarity(
                        baseTicket.getDescription(),
                        t.getDescription()
                );

                if (score >= rule.getThreshold()) {
                    DuplicateDetectionLog log = new DuplicateDetectionLog();
                    log.setTicket(baseTicket);
                    log.setMatchedTicket(t);
                    log.setMatchScore(score);
                    logs.add(logRepository.save(log));
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
                .orElseThrow(() -> new RuntimeException("log not found"));
    }
}