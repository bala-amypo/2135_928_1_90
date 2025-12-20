package com.example.demo.service;

import com.example.demo.model.DuplicateDetectionLog;
import com.example.demo.model.Ticket;

import java.util.List;

public interface DuplicateDetectionService {

    List<DuplicateDetectionLog> detectDuplicate(Ticket ticket);

    List<DuplicateDetectionLog> getAllLogs();

    DuplicateDetectionLog getLogById(Long id);
}
