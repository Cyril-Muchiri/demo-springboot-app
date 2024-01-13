package com.example.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.example.dto.StudentDtoI;
import com.example.entity.Student;
import com.example.services.StudentService;

// @Component
public class StudentClientCli implements CommandLineRunner {

	private final StudentDtoI dtoI;

	@Autowired
	public StudentClientCli(StudentDtoI dtoI) {
		this.dtoI = dtoI;
	}

	@Override
	public void run(String... args) throws Exception {

		boolean choice = true;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Student program running!!");
		System.out.println("Please wait as the program initializes---***!");
		Thread.sleep(3000);

		while (choice) {
			System.out.println("Enter student name : ");
			String studentName = scanner.nextLine();
			
			System.out.println("Enter student email : ");
			String email = scanner.nextLine();
			
			System.out.println("Enter student address : ");
			String address = scanner.nextLine();

			Student student = new Student();

			student.setName(studentName);
			student.setEmail(email);
			student.setAddress(address);

			StudentService service = new StudentService(dtoI);
			service.addStudent(student);

			System.out.println("Student successfully added ");
			Thread.sleep(2000);

			System.out.println("Do you wish to add another student : Y/N");
			String var = scanner.next().toUpperCase();

			switch (var) {
				case "Y":
					break;
				case "N":
					choice = false;
					break;
				default:
					choice = false;
					break;
			}
		}
		scanner.close();
	}
}
