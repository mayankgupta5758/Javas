package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class DepartmentResponseDto {

	private Long id;

	private String departmentName;

	private String location;

	private List<EmployeeResponseDto> employees;
}