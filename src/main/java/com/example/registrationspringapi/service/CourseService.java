package com.example.registrationspringapi.service;

import com.example.registrationspringapi.model.Course;
import com.example.registrationspringapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository dao;

    public void saveCourse(Course course){
        dao.save(course);
    }

    public List<Course> getCourses(){
        return dao.findAll();
    }
}
