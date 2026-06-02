package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.DepartmentRequestDto;
import com.example.demo.dto.DepartmentResponseDto;
import com.example.demo.dto.PageResponseDto;

public interface DepartmentService {

	DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

	List<DepartmentResponseDto> getAllDepartments();

	PageResponseDto<DepartmentResponseDto> getAllDepartmentsWithPagination(int pageNumber, int pageSize);

	DepartmentResponseDto getDepartmentById(Long id);

	DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto departmentRequestDto);

	void deleteDepartment(Long id);
}