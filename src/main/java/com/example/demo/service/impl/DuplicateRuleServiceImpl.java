package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository repository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DuplicateRule createRule(DuplicateRule rule) {

        if (repository.findByRuleName(rule.getRuleName()).isPresent()) {
            throw new IllegalArgumentException("rule already exists");
        }

        if (rule.getThreshold() < 0.0 || rule.getThreshold() > 1.0) {
            throw new IllegalArgumentException("invalid threshold");
        }

        return repository.save(rule);
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public DuplicateRule getRule(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Rule not found"));
    }
}
