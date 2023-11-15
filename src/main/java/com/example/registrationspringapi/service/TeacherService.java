package com.example.registrationspringapi.service;

import com.example.registrationspringapi.model.AcademicUnit;
import com.example.registrationspringapi.model.Teacher;
import com.example.registrationspringapi.repository.AcademicUnitRepository;
import com.example.registrationspringapi.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherDao;
    @Autowired
    private AcademicUnitRepository unitDao;

    public void saveTeacher(Teacher teacher){
        teacherDao.save(teacher);
    }

    public List<Teacher> getTeachers(){
        return teacherDao .findAll();
    }

    public void assignTeacherToUnit(String teacherId, String unitId){
        List<AcademicUnit> unitSet = null;
        List<Teacher> teacherSet = null;

        Teacher teacher = teacherDao.findById(teacherId).get();
        AcademicUnit academicUnit = unitDao.findById(unitId).get();

        unitSet = teacher.getAcademicUnits();
        unitSet.add(academicUnit);
        teacher.setAcademicUnits(unitSet);

        teacherSet = academicUnit.getTeachers();
        teacherSet.add(teacher);
        academicUnit.setTeachers(teacherSet);

        teacherDao.save(teacher);
        unitDao.save(academicUnit);


    }
}
