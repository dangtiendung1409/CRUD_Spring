package com.example.demospring2.dao;

import com.example.demospring2.entity.ClassRoom;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ClassRoom> getAllClassRooms( ){
        return  this.entityManager.createQuery("from ClassRoom ", ClassRoom.class).getResultList();
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