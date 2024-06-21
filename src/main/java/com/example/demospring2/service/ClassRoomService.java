package com.example.demospring2.service;

import com.example.demospring2.dao.IClassRoomDAO;
import com.example.demospring2.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomService {
    private final IClassRoomDAO classRoomDAO;

    @Autowired
    public ClassRoomService(IClassRoomDAO classRoomDAO) {
        this.classRoomDAO = classRoomDAO;
    }

    public Page<ClassRoom> getAllClassRooms(Pageable pageable) {
        return classRoomDAO.getAllClassRooms(pageable);
    }

    public ClassRoom getClassRoomById(long id) {
        return classRoomDAO.getClassRoomById(id);
    }

    public void saveClassRoom(ClassRoom classRoom) {
        classRoomDAO.saveClassRoom(classRoom);
    }

    public void updateClassRoom(long id, ClassRoom classRoomDetails) {
        ClassRoom classRoom = classRoomDAO.getClassRoomById(id);
        if (classRoom != null) {
            classRoom.setClassName(classRoomDetails.getClassName());
            classRoom.setNumberMember(classRoomDetails.getNumberMember());
            classRoomDAO.saveClassRoom(classRoom);
        }
    }

    public void deleteClassRoom(long id) {
        ClassRoom classRoom = classRoomDAO.getClassRoomById(id);
        if (classRoom != null) {
            classRoomDAO.deleteClassRoom(classRoom);
        }
    }
}
