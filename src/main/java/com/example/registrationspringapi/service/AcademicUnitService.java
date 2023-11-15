package com.example.registrationspringapi.service;

import com.example.registrationspringapi.model.AcademicUnit;
import com.example.registrationspringapi.repository.AcademicUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicUnitService {

    @Autowired
    private AcademicUnitRepository dao;

    public void saveUnit(AcademicUnit unit){
        dao.save(unit);
    }

    public List<AcademicUnit> getUnits(){
        return dao.findAll();
    }
}
