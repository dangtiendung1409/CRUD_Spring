package com.example.demospring2.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "class_room")
public class ClassRoom {
    @Column(name = "class_name")
    private String className;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private int idClass;

    @Column(name = "number_member")
    private int numberMember;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Student> students;

    // Getters and Setters

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public int getNumberMember() {
        return numberMember;
    }

    public void setNumberMember(int numberMember) {
        this.numberMember = numberMember;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public ClassRoom() {}

    public ClassRoom(String className, int numberMember) {
        this.className = className;
        this.numberMember = numberMember;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "className='" + className + '\'' +
                ", idClass=" + idClass +
                ", numberMember=" + numberMember +
                '}';
    }
}
