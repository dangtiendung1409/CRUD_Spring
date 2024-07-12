package com.example.demospring2.controllers;

import com.example.demospring2.service.StudentService;
import com.example.demospring2.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demospring2.entity.Student;
import com.example.demospring2.service.ClassRoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final ClassRoomService classRoomService;

    @Autowired
    public StudentController(StudentService studentService, ClassRoomService classRoomService) {
        this.studentService = studentService;
        this.classRoomService = classRoomService;
    }

    @GetMapping("/list")
    public String getStudentList(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/save")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classRooms", classRoomService.getAllClassRooms());
        return "student/add_student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("classRooms", classRoomService.getAllClassRooms());
            return "student/add_student";
        }

        studentService.saveStudent(student);
        return "redirect:/student/list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return "404";
        }
        model.addAttribute("student", student);
        model.addAttribute("classRooms", classRoomService.getAllClassRooms()); // Truyền danh sách lớp học
        return "student/edit_student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id, @ModelAttribute Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/student/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }
    @GetMapping("/all-with-procedure")
    public ResponseEntity<List<StudentDTO>> getAllStudentsWithProcedure() {
        List<StudentDTO> students = studentService.getAllStudentsWithProcedure();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}