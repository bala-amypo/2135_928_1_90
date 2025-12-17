package com.example.demo.controller;
import java.util.Collection;
import org.springFramework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;
@RestController
@RequestMapping("/student")
public class studctl(
    @Autowired
    private Studservice ser;
    //POST
    @postMapping("/add")
)