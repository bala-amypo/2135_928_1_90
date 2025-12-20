package com.example.demo.service;

import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryService {

    private final TicketCategoryRepository repository;

    public TicketCategoryService(TicketCategoryRepository repository) {
        this.repository = repository;
    }

    public TicketCategory createCategory(TicketCategory category) {
        return repository.save(category);
    }

    public List<TicketCategory> getAllCategories() {
        return repository.findAll();
    }
}
