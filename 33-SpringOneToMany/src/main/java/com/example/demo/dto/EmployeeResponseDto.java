package com.example.demo.dto;

import lombok.Data;

@Data
public class EmployeeResponseDto {

	private Long id;

	private String employeeName;

	private String email;

	private Double salary;
}