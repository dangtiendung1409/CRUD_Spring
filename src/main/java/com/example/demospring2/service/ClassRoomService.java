package com.example.demospring2.service;

import com.example.demospring2.dao.IClassRoomDAO;
import com.example.demospring2.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {
    private final IClassRoomDAO classRoomDAO;

    @Autowired
    public ClassRoomService(IClassRoomDAO classRoomDAO) {
        this.classRoomDAO = classRoomDAO;
    }
    // Phương thức để lấy danh sách lớp học
    public List<ClassRoom> getAllClassRooms() {
        // Chỉ cần trả về danh sách lớp học, không cần phân trang ở đây
        return classRoomDAO.getAllClassRooms(PageRequest.of(0, Integer.MAX_VALUE)).getContent();
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

    public String deleteClassRoom(long id) {
        ClassRoom classRoom = classRoomDAO.getClassRoomById(id);
        if (classRoom != null) {
            if (!classRoom.getStudents().isEmpty()) {
                return "Lớp học có học sinh, không thể xoá!";
            }
            classRoomDAO.deleteClassRoom(classRoom);
            return "Xóa lớp học thành công!";
        } else {
            return "Lớp học không tồn tại!";
        }
    }
}