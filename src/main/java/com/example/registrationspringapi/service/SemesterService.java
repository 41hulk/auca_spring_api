package com.example.registrationspringapi.service;
import com.example.registrationspringapi.model.Semester;
import com.example.registrationspringapi.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository dao;

    public void saveSemester(Semester semester){
        dao.save(semester);
    }

    public List<Semester> getSemesters(){
        return dao.findAll();
    }
}
