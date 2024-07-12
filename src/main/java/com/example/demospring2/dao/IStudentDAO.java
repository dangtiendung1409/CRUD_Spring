package com.example.demospring2.dao;
import com.example.demospring2.entity.Student;
import com.example.demospring2.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentDAO {
    void saveStudent(Student student);
    Student getStudentById(int id);

    List<Student> getAllStudents();

    void deleteStudent(Student student);
    @Query(value = "call SP_GET_STUDENT_BY_CLASS", nativeQuery = true)
    List<StudentDTO> getAllStudentsWithProcedure();

}
