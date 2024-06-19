package com.example.demospring2.dao;

import com.example.demospring2.entity.Student;
import java.util.List;

public interface IStudentDAO {
    void saveStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    void deleteStudent(Student student);
}
