package com.example.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dto.StudentDtoI;
import com.example.entity.Student;

@Configuration
public class StudentConfig {

    // @Bean
    // CommandLineRunner runner(StudentDtoI dStudentDtoI) {
    //     return args -> {
    //         Student Mary = new Student("Mary Mutua", "mutua@test.com", "1104-uthiru");
    //         Student Baracuda = new Student("Baracuda", "Baracuda@test.com", "noneya-009");
    //         Student putin = new Student("Putin vladmir", "tsar@test.com", "Moscow-kremlin");

    //         // dStudentDtoI.saveAll(
    //         //         List.of(Mary, Baracuda, putin));
    //     };

    // }



}
