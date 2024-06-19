package com.example.demospring2.controllers;

import com.example.demospring2.entity.ClassRoom;
import com.example.demospring2.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassController {

    private final ClassRoomService classRoomService;

    @Autowired
    public ClassController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping("/list")
    public String getClassRoomList(Model model) {
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        model.addAttribute("classRooms", classRooms);
        return "class/index";
    }

    @GetMapping("/save")
    public String showCreateForm(Model model) {
        model.addAttribute("classRoom", new ClassRoom());
        return "class/add_classroom";
    }

    @PostMapping("/save")
    public String saveClassRoom(@ModelAttribute ClassRoom classRoom) {
        classRoomService.saveClassRoom(classRoom);
        return "redirect:/classroom/list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        ClassRoom classRoom = classRoomService.getClassRoomById(id);
        if (classRoom == null) {
            return "404";
        }
        model.addAttribute("classRoom", classRoom);
        return "class/edit_classroom";
    }

    @PostMapping("/update/{id}")
    public String updateClassRoom(@PathVariable("id") long id, @ModelAttribute ClassRoom classRoom) {
        classRoomService.updateClassRoom(id, classRoom);
        return "redirect:/classroom/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteClassRoom(@PathVariable("id") long id) {
        classRoomService.deleteClassRoom(id);
        return "redirect:/classroom/list";
    }
}