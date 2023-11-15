package com.example.registrationspringapi.controller;

import com.example.registrationspringapi.model.StudentRegistration;
import com.example.registrationspringapi.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    private final StudentRegistrationService service;

    @Autowired
    public RegistrationController(StudentRegistrationService service){
        this.service=service;
    }

    @GetMapping
    public List<StudentRegistration> getAllRegistrations(){
        return service.getRegistrations();
    }

    @PostMapping
    public ResponseEntity<String> registerStudent(@RequestBody StudentRegistration registration){
        try{
            service.saveRegistration(registration);
            return new ResponseEntity<>("Registration saved", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
