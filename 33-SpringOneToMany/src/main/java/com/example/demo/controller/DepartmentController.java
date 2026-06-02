package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
@Validated
public class DepartmentController {

	private final DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<DepartmentResponseDto> createDepartment(@Valid @RequestBody DepartmentRequestDto dto) {
		return new ResponseEntity<>(departmentService.createDepartment(dto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Long id) {
		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable Long id,
			@Valid @RequestBody DepartmentRequestDto dto) {
		return ResponseEntity.ok(departmentService.updateDepartment(id, dto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/page")
	public ResponseEntity<PageResponseDto<DepartmentResponseDto>> getAllDepartmentsWithPagination(
			@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize) {
		return ResponseEntity.ok(departmentService.getAllDepartmentsWithPagination(pageNumber, pageSize));
	}
}