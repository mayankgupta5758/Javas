package com.example.demo.exception;

public class DepartmentNotFoundException extends RuntimeException{
 
	public DepartmentNotFoundException(Long id) {
		super("Department Node found: " + id);
	}
}
