package com.example.demospring2.dao;

import com.example.demospring2.entity.Student;
import com.example.demospring2.dto.StudentDTO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Query;
import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO {
    private EntityManager entityManager;

    @Autowired
    public StudentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }
    @Override
    public List<StudentDTO> getAllStudentsWithProcedure() {
        Query query = entityManager.createNativeQuery("CALL SP_GET_STUDENT_BY_CLASS()", StudentDTO.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public void deleteStudent(Student student) {
        if (entityManager.contains(student)) {
            entityManager.remove(student);
        } else {
            entityManager.remove(entityManager.merge(student));
        }
    }
}