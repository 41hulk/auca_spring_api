package com.example.registrationspringapi.controller;

import com.example.registrationspringapi.model.StudentRegistration;
import com.example.registrationspringapi.model.Teacher;
import com.example.registrationspringapi.service.StudentRegistrationService;
import com.example.registrationspringapi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {

    private final TeacherService service;

    @Autowired
    public TeacherController(TeacherService service){
        this.service=service;
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return service.getTeachers();
    }

    @PostMapping
    public ResponseEntity<String> registerTeacher(@RequestBody Teacher teacher){
        try{
            service.saveTeacher(teacher);

            return new ResponseEntity<>("Teacher saved", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{teacherId}/unit/{unitId}")
    public ResponseEntity<String> assignTeacherToUnit(@PathVariable String teacherId, @PathVariable String unitId){
        service.assignTeacherToUnit(teacherId,unitId);

        return new ResponseEntity<>("Teacher Assigned", HttpStatus.CREATED);
    }

}
