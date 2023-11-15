package com.example.registrationspringapi.repository;

import com.example.registrationspringapi.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, String> {
}
