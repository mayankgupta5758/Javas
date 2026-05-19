package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentDAO;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
        return runner -> {

            createStudent(studentDao);
            readStudent(studentDao);
            readAllStudent(studentDao);
        };
    }

    private void createStudent(StudentDAO studentDao) {
        System.out.println("Creating new student object");
        Student tempStudent1 = new Student(1, "Mayank");
        Student tempStudent2 = new Student(2, "Samay");
        Student tempStudent3 = new Student(3, "Time");
        System.out.println("Saving student record");
        studentDao.save(tempStudent1);
        studentDao.save(tempStudent2);
        studentDao.save(tempStudent3);
        System.out.println("Saved student");
    }

    private void readStudent(StudentDAO studentDao) {
        System.out.println("Retrieving student record from database");
        Student foundStudent = studentDao.findById(1);
        System.out.println("Found the student: " + foundStudent);
    }
    
    private void readAllStudent(StudentDAO studentDao) {
    	System.out.println("Retrieving all student record from database");
    	List<Student> list = studentDao.readAllStudent();
    	
    	for(Student s: list) {
    		System.out.println("Found the student: " + s);
    	}
    }
}