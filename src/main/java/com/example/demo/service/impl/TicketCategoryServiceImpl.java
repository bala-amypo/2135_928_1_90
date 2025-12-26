package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketCategoryServiceImpl implements TicketCategoryService {

    private final TicketCategoryRepository repository;

    public TicketCategoryServiceImpl(TicketCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketCategory createCategory(TicketCategory category) {

        if (repository.existsByCategoryName(category.getCategoryName())) {
            throw new IllegalArgumentException("category already exists");
        }

        return repository.save(category);
    }

    @Override
    public List<TicketCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public TicketCategory getCategory(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Category not found"));
    }
}
