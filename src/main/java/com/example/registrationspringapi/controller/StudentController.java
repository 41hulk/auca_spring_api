package com.example.registrationspringapi.controller;

import com.example.registrationspringapi.model.Student;
import com.example.registrationspringapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        try {
            studentService.addNewStudent(student);
            return new ResponseEntity<>("Student Registered", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
