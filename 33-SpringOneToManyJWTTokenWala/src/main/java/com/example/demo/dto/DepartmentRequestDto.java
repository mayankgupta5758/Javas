package com.example.demo.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DepartmentRequestDto {

	@NotBlank(message = "Department name can't be empty")
	private String departmentName;

	@NotBlank(message = "Location can't be empty")
	private String location;

	@Valid
	@NotEmpty(message = "At least one employee is required")
	private List<EmployeeRequestDto> employees;
}