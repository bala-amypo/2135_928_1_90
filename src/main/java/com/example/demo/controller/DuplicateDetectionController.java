package com.example.demo.controller;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.repository.DuplicateDetectionLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class DuplicateDetectionLogController {

    private final DuplicateDetectionLogRepository repository;

    public DuplicateDetectionLogController(DuplicateDetectionLogRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<DuplicateDetectionLog> getLogs() {
        return repository.findAll();
    }
}
