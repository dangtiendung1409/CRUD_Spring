package com.example.demospring2.dao;

import com.example.demospring2.entity.ClassRoom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRoomDAO implements IClassRoomDAO {
    private EntityManager entityManager;
    @Autowired
    public ClassRoomDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveClassRoom(ClassRoom classRoom) {
        this.entityManager.persist(classRoom);

    }

    public ClassRoom getClassRoomById(long id){
        return  this.entityManager.find(ClassRoom.class, id);
    }


    public Page<ClassRoom> getAllClassRooms(Pageable pageable){
        TypedQuery<ClassRoom> query = this.entityManager.createQuery("from ClassRoom", ClassRoom.class);
        int totalRows = query.getResultList().size();
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        List<ClassRoom> classRooms = query.getResultList();
        return new PageImpl<>(classRooms, pageable, totalRows);
    }

    @Override
    @Transactional
    public void deleteClassRoom(ClassRoom classRoom) {
        if (entityManager.contains(classRoom)) {
            entityManager.remove(classRoom);
        } else {
            entityManager.remove(entityManager.merge(classRoom));
        }
    }
}