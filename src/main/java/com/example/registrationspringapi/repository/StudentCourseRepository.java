package com.example.registrationspringapi.repository;

import com.example.registrationspringapi.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, String> {
}
