package com.example.demo.controller;
import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/duplicates")
public class DuplicateDetectionController {
    private final DuplicateDetectionService detectionService;
    public DuplicateDetectionController(DuplicateDetectionService detectionService) {
        this.detectionService = detectionService;
    }
    @PostMapping("/detect/{ticketId}")
    public List<DuplicateDetectionLog> detectDuplicates(@PathVariable Long ticketId) {
        return detectionService.detectDuplicates(ticketId);
    }
    @GetMapping("/ticket/{ticketId}")
    public List<DuplicateDetectionLog> getLogsForTicket(@PathVariable Long ticketId) {
        return detectionService.getLogsForTicket(ticketId);
    }
    @GetMapping("/{id}")
    public DuplicateDetectionLog getLog(@PathVariable Long id) {
        return detectionService.getLog(id);
    }
}