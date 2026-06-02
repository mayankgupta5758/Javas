package com.example.demo.entity.exception;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(long id) {
		super("Student not found with id : " + id);

	}
}
