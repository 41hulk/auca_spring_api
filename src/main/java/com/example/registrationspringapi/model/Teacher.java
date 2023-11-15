package com.example.registrationspringapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@Data
public class Teacher {
    @Id
    @UuidGenerator
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EQualification qualification;

    @ManyToMany
    @JoinTable(
            name = "teacher_academicunit",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "academicunit_id")
    )

    @JsonIgnore
    private List<AcademicUnit> academicUnits;


    public Teacher() {
    }

    public Teacher(String id, String name, EQualification qualification, List<AcademicUnit> academicUnits) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.academicUnits = academicUnits;
    }
}
