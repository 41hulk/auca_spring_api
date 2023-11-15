package com.example.registrationspringapi.repository;

import com.example.registrationspringapi.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, String> {
}
