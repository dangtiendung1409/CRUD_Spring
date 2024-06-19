package com.example.demospring2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
        @GetMapping("/listStudent")
        public String getClassRoomList(){
            return "student/index";
        }

    }
