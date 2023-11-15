package com.example.registrationspringapi.controller;

import com.example.registrationspringapi.model.AcademicUnit;
import com.example.registrationspringapi.model.StudentRegistration;
import com.example.registrationspringapi.service.AcademicUnitService;
import com.example.registrationspringapi.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/academic-unit")
public class AcademicUnitController {

    private final AcademicUnitService service;

    @Autowired
    public AcademicUnitController(AcademicUnitService service){
        this.service=service;
    }

    @GetMapping
    public List<AcademicUnit> getAllUnits(){
        return service.getUnits();
    }

    @PostMapping
    public ResponseEntity<String> registerAcademicUnit(@RequestBody AcademicUnit unit){
        try{
            service.saveUnit(unit);
            return new ResponseEntity<>("Academic Unit Saved", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
