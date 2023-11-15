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
@Table(name = "Studentregistration")
public class StudentRegistration {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "regNo")
    private Student student;

    private LocalDate regDate;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private AcademicUnit academicUnit;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public StudentRegistration() {
    }

    public StudentRegistration(String id, Student student, LocalDate regDate, Semester semester, AcademicUnit academicUnit, List<Course> courses) {
        this.id = id;
        this.student = student;
        this.regDate = regDate;
        this.semester = semester;
        this.academicUnit = academicUnit;
        this.courses = courses;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AcademicUnit getAcademicUnit() {
        return academicUnit;
    }

    public void setAcademicUnit(AcademicUnit academicUnit) {
        this.academicUnit = academicUnit;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentRegistration{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", regDate=" + regDate +
                ", semester=" + semester +
                ", academicUnit=" + academicUnit +
                ", courses=" + courses +
                '}';
    }
}
