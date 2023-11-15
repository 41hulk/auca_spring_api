package com.example.registrationspringapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "academic_unit")
@Getter
@Setter
public class AcademicUnit {
    @Id
    @UuidGenerator
    @Column(name = "unit_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EAcademicUnit type;


    @ManyToMany
    @JoinTable(
            name = "teacher_academicunit",
            joinColumns = @JoinColumn(name = "academicunit_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;

    @ManyToOne
    @JoinColumn(name = "unit")
    private AcademicUnit unit;

    public AcademicUnit() {
    }

    public AcademicUnit(String id, String name, EAcademicUnit type, List<Teacher> teachers, AcademicUnit unit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.teachers = teachers;
        this.unit = unit;
    }
}
