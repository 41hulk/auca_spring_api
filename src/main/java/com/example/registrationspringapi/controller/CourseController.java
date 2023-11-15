package com.example.registrationspringapi.controller;

import com.example.registrationspringapi.model.Course;
import com.example.registrationspringapi.model.Semester;
import com.example.registrationspringapi.service.CourseService;
import com.example.registrationspringapi.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    private final CourseService service;

    @Autowired
    public CourseController(CourseService service){
        this.service=service;
    }

    @GetMapping
    public List<Course> getAllCourse(){
        return service.getCourses();
    }

    @PostMapping
    public ResponseEntity<String> registerCourse(@RequestBody Course course){
        try{
            service.saveCourse(course);
            return new ResponseEntity<>("Course Registered", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
