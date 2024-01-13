package com.example.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.services.StudentService;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/find")
    public Student findStudentDetails(@RequestBody Map<String, String> requestBody) {
        Student student = studentService.findStudent(requestBody.get("email"));

        if (student == null) {
            return null;
        } else {
            return student;
        }

    }

    @DeleteMapping
    public void deleteByEmail(@RequestBody Map<String, String> requestBody) {
        Student delStudent = studentService.findStudent(requestBody.get("email"));
        if (delStudent == null) {
            throw new IllegalStateException("No student by that email Available!!");
        } else {
            studentService.deleteStudent(delStudent);
        }
    }

    @PutMapping
    public void modifyAddress(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String newAddress = requestBody.get("new_Address");

        Student modifyStudent = studentService.findStudent(email);
        if (modifyStudent == null) {
            throw new IllegalStateException("No student by that email exists");
        } else {
            studentService.modifyStudentDetail(newAddress, modifyStudent);
        }
    }
}
