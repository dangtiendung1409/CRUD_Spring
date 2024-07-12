package com.example.demospring2.service;

import com.example.demospring2.dao.IStudentDAO;
import com.example.demospring2.dto.StudentDTO;
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

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }
    public List<StudentDTO> getAllStudentsWithProcedure() {
        return studentDAO.getAllStudentsWithProcedure();
    }
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public void updateStudent(int id, Student studentDetails) {
        Student student = studentDAO.getStudentById(id);
        if (student != null) {
            student.setEmail(studentDetails.getEmail());
            student.setFirstName(studentDetails.getFirstName());
            student.setLastName(studentDetails.getLastName());
            student.setClassRoom(studentDetails.getClassRoom()); // Cập nhật thông tin lớp học
            studentDAO.saveStudent(student);
        }
    }

    public void deleteStudent(int id) {
        Student student = studentDAO.getStudentById(id);
        if (student != null) {
            studentDAO.deleteStudent(student);
        }
    }
}