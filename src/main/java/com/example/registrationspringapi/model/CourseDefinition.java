package com.example.registrationspringapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;

@Entity
@Table()
@Getter
@Setter
public class CourseDefinition {
    @Id
    @UuidGenerator
    @OneToOne
    @JoinColumn(name = "id")
    private Course id;

    private String name;
    private String description;

    public CourseDefinition() {
    }

    public CourseDefinition(Course id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
