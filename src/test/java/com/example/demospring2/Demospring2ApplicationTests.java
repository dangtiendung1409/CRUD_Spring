package com.example.demospring2;

import com.example.demospring2.dao.ClassRoomDAO;
import com.example.demospring2.entity.ClassRoom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demospring2ApplicationTests {

    public static void main(String[] args) {

        SpringApplication.run(Demospring2ApplicationTests.class, args);
        System.out.println("test");
    }

    @Bean
    public static CommandLineRunner commandLineRunner(ClassRoomDAO classRoomDAO){
        return args -> {
            System.out.println("start...");
            getClassById(classRoomDAO);
            addNewClass(classRoomDAO);

        };
    }

    private static void addNewClass(ClassRoomDAO classRoomDAO){
//        ClassRoom classRoom = new ClassRoom();
//        classRoom.setClassName("12A1");
//        classRoom.setNumberMember(22);
//        classRoomDAO.saveClassRoom(classRoom);
    }

    private static void getClassById(ClassRoomDAO classRoomDAO){
//        ClassRoom classRoom = classRoomDAO.getClassRoomById(3l);
//        System.out.println(classRoom.toString());
    }
}