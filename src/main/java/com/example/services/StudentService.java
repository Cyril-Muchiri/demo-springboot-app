package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.StudentDtoI;
import com.example.entity.Student;

@Component
public class StudentService {

    private final StudentDtoI dtoI;

    @Autowired
    public StudentService(StudentDtoI dtoI) {
        this.dtoI = dtoI;
    }

    public List<Student> getStudents() {
        System.out.println(dtoI.findAll().toString());
        return dtoI.findAll();
    }

    public void addStudent(Student student) {
        dtoI.save(student);

    }

    public Student findStudent(String email) {
        return dtoI.findByEmail(email);
    }

    public void deleteStudent(Student student) {
        StudentService service = new StudentService(dtoI);
        student = service.findStudent(student.getEmail());
        dtoI.delete(student);
    }

    public void modifyStudentDetail(String newAdress,Student student) {
        StudentService service = new StudentService(dtoI);
        student=service.findStudent(student.getEmail());
        student.setAddress(newAdress);
        dtoI.save(student);
        

    }

}
