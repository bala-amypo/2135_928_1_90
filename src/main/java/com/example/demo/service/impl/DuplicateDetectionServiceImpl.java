package com.example.demo.service.impl;
import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.stereotype.Service;import java.util.List;

@Service
public class DuplicateDetectionServiceImpl implements DuplicateDetectionService {
    private final DuplicateDetectionLogRepository logRepository;
    public DuplicateDetectionServiceImpl(DuplicateDetectionLogRepository logRepository) {
    this.logRepository = logRepository;
    }
    @Override
    public List<DuplicateDetectionLog> detectDuplicates(Long ticketId) {
        return logRepository.findByTicketId(ticketId);
    }
    @Override
    public List<DuplicateDetectionLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicketId(ticketId);
    }
    @Override
    public DuplicateDetectionLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "DuplicateDetectionLog not found with id: " + id
                ));
    }
}
