package com.example.demo.entity.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<Map<String, Object>> emailAlreadyExistException(EmailAlreadyExistException ex) {
		Map<String, Object> entityBody = new HashMap<>();
		entityBody.put("timestamp", LocalDateTime.now());
		entityBody.put("errorCode", HttpStatus.NOT_FOUND.value());
		entityBody.put("error", "NOT_FOUND");
		entityBody.put("message", ex.getMessage());
		
		return new ResponseEntity<>(entityBody, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleStudentNotFoundException(StudentNotFoundException ex) {
		Map<String, Object> entityBody = new HashMap<>();

		entityBody.put("Timestamp", LocalDateTime.now());
		entityBody.put("status", HttpStatus.NOT_FOUND.value());
		entityBody.put("message", ex.getMessage());
		entityBody.put("error", "not found");

		return new ResponseEntity<>(entityBody, HttpStatus.NOT_FOUND);
	}
}
