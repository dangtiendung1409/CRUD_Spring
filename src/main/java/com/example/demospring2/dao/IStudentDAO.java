package com.example.demospring2.dao;
import com.example.demospring2.entity.Student;
import com.example.demospring2.entity.ClassRoom;

import jakarta.transaction.Transactional;

import java.util.List;

public interface IStudentDAO {
    void saveStudent(Student student);
    Student getStudentById(int id);
    List<Student> getAllStudents();
    void deleteStudent(Student student);

}
