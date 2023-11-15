package com.example.registrationspringapi.service;

import com.example.registrationspringapi.model.StudentRegistration;
import com.example.registrationspringapi.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationService {

    @Autowired
    private StudentRegistrationRepository dao;

    public void saveRegistration(StudentRegistration registration){
        dao.save(registration);
    }

    public List<StudentRegistration> getRegistrations(){
        return dao.findAll();
    }
}
