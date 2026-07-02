package com.example.demo.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationErrorResponse {

	private int status;

	private String message;

	private Map<String, String> errors;

	private LocalDateTime timestamp;
}