package com.example.registrationspringapi.repository;

import com.example.registrationspringapi.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
