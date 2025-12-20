package com.example.demo.controller;

import com.example.demo.service.DuplicateDetectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detection")
public class DuplicateDetectionController {

    private final DuplicateDetectionService service;

    public DuplicateDetectionController(DuplicateDetectionService service) {
        this.service = service;
    }

    @GetMapping("/run/{ticketId}")
    public String runDetection(@PathVariable Long ticketId) {
        service.runDetection(ticketId);
        return "Duplicate detection completed";
    }
}
