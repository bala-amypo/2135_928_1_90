package com.example.demo.service;

import com.example.demo.model.TicketCategory;
import java.util.List;

public interface DuplicateRuleService {

    TicketCategory createRule(TicketCategory category);

    TicketCategory getRule(Long id);

    List<TicketCategory> getAllRules();

    void deleteRule(Long id);
}
