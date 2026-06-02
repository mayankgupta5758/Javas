package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentRequestDto;
import com.example.demo.dto.DepartmentResponseDto;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
@Validated
@Slf4j
public class DepartmentController {

	private final DepartmentService departmentService;

	@PostMapping
	public DepartmentResponseDto createDepartment(@Valid @RequestBody DepartmentRequestDto dto) {
		log.info("POST request received for creating department");
		return  departmentService.createDepartment(dto);
	}

	@GetMapping
	public List<DepartmentResponseDto> getAllDepartments() {
		log.info("GET request received for fetching all departments");
		return departmentService.getAllDepartments();
	}

	@GetMapping("/{id}")
	public DepartmentResponseDto getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

	@PutMapping("/{id}")
	public DepartmentResponseDto updateDepartment(@PathVariable Long id,
			@Valid @RequestBody DepartmentRequestDto dto) {
		log.info("PUT request received for updating department id {}", id);
		return departmentService.updateDepartment(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartment(@PathVariable Long id) {
        log.info("DELETE request received for department id {}", id);
		departmentService.deleteDepartment(id);
	}

	@GetMapping("/page")
	public PageResponseDto<DepartmentResponseDto> getAllDepartmentsWithPagination(
			@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize) {
		return departmentService.getAllDepartmentsWithPagination(pageNumber, pageSize);
	}
}