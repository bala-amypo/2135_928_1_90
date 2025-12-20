package com.example.demo.service.impl;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.Ticket;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {

    private final DuplicateDetectionLogRepository logRepository;

    public DuplicateDetectionServiceImpl(DuplicateDetectionLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<DuplicateDetectionLog> detectDuplicate(Ticket ticket) {

        List<DuplicateDetectionLog> logs = new ArrayList<>();

        // Example logic (replace with real rule checks later)
        if (ticket.getTitle() != null && ticket.getTitle().length() > 5) {
            DuplicateDetectionLog log = new DuplicateDetectionLog();
            log.setTicket(ticket);
            log.setMessage("Possible duplicate detected based on title");
            log.setDetectedAt(LocalDateTime.now());

            logs.add(logRepository.save(log));
        }

        return logs;
    }

    @Override
    public List<DuplicateDetectionLog> getAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public DuplicateDetectionLog getLogById(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DuplicateDetectionLog not found with id " + id));
    }
}
