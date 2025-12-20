package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;

@RestController
@RequestMapping("/categories")
public class TicketCategoryController {

    private final TicketCategoryRepository repo;

    public TicketCategoryController(TicketCategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<TicketCategory> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public TicketCategory save(@RequestBody TicketCategory c) {
        return repo.save(c);
    }
}
