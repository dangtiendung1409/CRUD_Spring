package com.example.demospring2.dao;

import com.example.demospring2.entity.ClassRoom;
import java.util.List;

public interface IClassRoomDAO {
    void saveClassRoom(ClassRoom classRoom);
    ClassRoom getClassRoomById(long id);
    List<ClassRoom> getAllClassRooms();
    void deleteClassRoom(ClassRoom classRoom);
}
