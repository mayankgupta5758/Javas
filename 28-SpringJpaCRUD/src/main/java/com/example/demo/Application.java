package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		
		Student student = new Student();
		student.setMarks(98);
		student.setName("Mayank");
		student.setRollNo(1);
		
		StudentService studentService = applicationContext.getBean(StudentServiceImpl.class);
		boolean status = studentService.addStudentDetails(student);
		if(status) {
			System.out.println("Student Added Successfully");
		} else {
			System.out.println("Not Inserted.");
		}
	}

}
