package com.example.demospring2.dto;

public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String class_name;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }



    public StudentDTO(String firstName, String lastName, String email, String class_name) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.class_name = class_name;
    }



}