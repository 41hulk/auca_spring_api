package com.example.registrationspringapi.controller;

import com.example.registrationspringapi.model.Semester;
import com.example.registrationspringapi.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/semester")
public class SemesterController {

    private final SemesterService service;

    @Autowired
    public SemesterController(SemesterService service){
        this.service=service;
    }

    @GetMapping
    public List<Semester> getAllSemester(){
        return service.getSemesters();
    }

    @PostMapping
    public ResponseEntity<String> registerStudent(@RequestBody Semester semester){
        try{
            service.saveSemester(semester);
            return new ResponseEntity<>("Semester Registered", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
