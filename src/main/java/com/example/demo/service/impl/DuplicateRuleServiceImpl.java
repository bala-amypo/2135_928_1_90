package com.example.demo.service.impl;
import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {
    private final DuplicateRuleRepository duplicateRuleRepository;
    public DuplicateRuleServiceImpl(DuplicateRuleRepository duplicateRuleRepository) {
    this.duplicateRuleRepository = duplicateRuleRepository;
    }
    @Override
    public DuplicateRule createRule(DuplicateRule rule) {
    return duplicateRuleRepository.save(rule);
    }

    @Override
    public List<DuplicateRule> getAllRules() {
        return duplicateRuleRepository.findAll();
    }

    @Override
    public DuplicateRule getRuleById(Long id) {
        return duplicateRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DuplicateRule not found with id " + id));
    }

    @Override
    public void deleteRule(Long id) {
        duplicateRuleRepository.deleteById(id);
    }
}
