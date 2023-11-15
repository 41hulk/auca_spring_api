package com.example.registrationspringapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @UuidGenerator
    private String regNo;
    private String name;
    private LocalDate dob;

    @ManyToMany
    @Column(name = "student_course")
    private List<Course> courses;

    public Student() {
    }

    public Student(String regNo, String name, LocalDate dob) {
        this.regNo = regNo;
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
