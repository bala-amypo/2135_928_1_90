package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.DuplicateDetectionLog;

public interface DuplicateDetectionLogRepository
        extends JpaRepository<DuplicateDetectionLog, Long> {
}
