package com.example.demo.service.impl;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    @Override
    public TicketCategory createRule(TicketCategory category) {
        return category;
    }

    @Override
    public TicketCategory getRule(Long id) {
        return null;
    }

    @Override
    public List<TicketCategory> getAllRules() {
        return List.of();
    }

    @Override
    public void deleteRule(Long id) {
    }
}
