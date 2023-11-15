package com.example.registrationspringapi.repository;

import com.example.registrationspringapi.model.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicUnitRepository extends JpaRepository<AcademicUnit, String> {
}
