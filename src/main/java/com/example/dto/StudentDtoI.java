package com.example.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
public interface StudentDtoI extends JpaRepository<Student,Integer>{
    
     Student findByEmail(String email);
}
