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
    @PostMapping("/add")
    public Studententity addStudent(@RequestBody student st){
        return ser.saveData(st);

    }
    //GET ALL
    @GetMapping("/getall")
    public Collection<Studententity>getAllStudents(){
        return ser.getAll();

    }
    //GET BY ID
    @GetMapping("/get/{id}")
    public Studententity getStudentById(@PathVariable int id){
        return ser.getById(id);

    }
    //PUT (UPDATE)
    @PutMapping("/update/{id}")
    public Studententity updateStudent(
        @PathVariable int id,
        @RequestBOdy Studententity st){
    return ser.update(id,st);
    }
}