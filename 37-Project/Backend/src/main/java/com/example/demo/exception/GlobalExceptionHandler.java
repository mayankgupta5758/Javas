package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.response.ErrorResponse;
import com.example.demo.dto.response.ValidationErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {

		ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateResource(DuplicateResourceException ex) {

		ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value(), LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(BudgetExceededException.class)
	public ResponseEntity<ErrorResponse> handleBudgetExceeded(BudgetExceededException ex) {

		ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		ValidationErrorResponse response = new ValidationErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Validation Failed", errors, LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

		ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}