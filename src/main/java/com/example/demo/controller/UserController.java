package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<String> users() {
        return List.of("User1", "User2");
    }
}
