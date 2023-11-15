package com.example.registrationspringapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Table(name = "studentcourse")
public class StudentCourse {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;
    @Column(name = "credits")
    private int credits;
    @Column(name = "results")
    private float results;
    @OneToOne
    private StudentRegistration studentRegistration;

    @OneToOne
    private Course course;

    public StudentCourse() {
    }

    public StudentCourse(String id, int credits, float results, StudentRegistration studentRegistration, Course course) {
        this.id = id;
        this.credits = credits;
        this.results = results;
        this.studentRegistration = studentRegistration;
        this.course = course;
    }
}
