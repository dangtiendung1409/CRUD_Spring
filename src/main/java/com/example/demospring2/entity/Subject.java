package com.example.demospring2.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "credit")
    private Integer credit;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SubjectStudent> subjectStudents;

    // Getters and Setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public List<SubjectStudent> getSubjectStudents() {
        return subjectStudents;
    }

    public void setSubjectStudents(List<SubjectStudent> subjectStudents) {
        this.subjectStudents = subjectStudents;
    }

    public Subject() {}

    public Subject(String code, String name, Integer credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
