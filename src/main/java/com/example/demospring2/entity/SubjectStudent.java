package com.example.demospring2.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "subject_student")
public class SubjectStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "subject_code")
    @JsonBackReference
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectStudent() {}

    public SubjectStudent(Subject subject, Student student) {
        this.subject = subject;
        this.student = student;
    }

    @Override
    public String toString() {
        return "SubjectStudent{" +
                "id=" + id +
                ", subject=" + subject +
                ", student=" + student +
                '}';
    }
}
