package com.example.demospring2.dao;

import com.example.demospring2.entity.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRoomDAO {
    void saveClassRoom(ClassRoom classRoom);
    ClassRoom getClassRoomById(long id);
    Page<ClassRoom> getAllClassRooms(Pageable pageable);
    void deleteClassRoom(ClassRoom classRoom);
}
