package com.example.demospring2.service;

import com.example.demospring2.dao.IStudentDAO;
import com.example.demospring2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final IStudentDAO studentDAO;

    @Autowired
    public StudentService(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void deleteStudent(Student student) {
        studentDAO.deleteStudent(student);
    }

    public void deleteStudentById(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            studentDAO.deleteStudent(student);
        }
    }
}
