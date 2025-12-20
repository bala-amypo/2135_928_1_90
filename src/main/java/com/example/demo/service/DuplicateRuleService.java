package com.example.demo.service;

import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateRuleService {

    private final DuplicateRuleRepository repository;

    public DuplicateRuleService(DuplicateRuleRepository repository) {
        this.repository = repository;
    }

    public DuplicateRule createRule(DuplicateRule rule) {
        return repository.save(rule);
    }

    public List<DuplicateRule> getAllRules() {
        return repository.findAll();
    }
}
