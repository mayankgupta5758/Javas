package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleStudentNotFoundException(StudentNotFoundException ex) {
		Map<String, Object> entityBody = new HashMap<>();

		entityBody.put("Timestamp", LocalDateTime.now());
		entityBody.put("status", HttpStatus.NOT_FOUND.value());
		entityBody.put("message", ex.getMessage());
		entityBody.put("error", "not found");

		return new ResponseEntity<>(entityBody, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TypeMismatchException.class)
	public ResponseEntity<Map<String, Object>> handleTypeMismatchException(TypeMismatchException ex) {
		Map<String, Object> entityBody = new HashMap<>();

		entityBody.put("Timestamp", LocalDateTime.now());
		entityBody.put("status", HttpStatus.BAD_REQUEST.value());
		entityBody.put("message", "Id must be number");
		entityBody.put("error", "BAD REQUEST");

		return new ResponseEntity<>(entityBody, HttpStatus.NOT_FOUND);
	}
	
}
