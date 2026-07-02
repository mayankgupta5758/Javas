package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.DepartmentBudgetRequestDto;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.DepartmentBudgetResponseDto;
import com.example.demo.dto.response.FinanceSummaryResponseDto;
import com.example.demo.enums.Department;
import com.example.demo.service.DepartmentBudgetService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/budgets")
@RequiredArgsConstructor
@Validated
@CrossOrigin("http://localhost:5173/")
public class DepartmentBudgetController {

	private final DepartmentBudgetService budgetService;

	@PostMapping
	public ResponseEntity<ApiResponse<DepartmentBudgetResponseDto>> createBudget(
			@Valid @RequestBody DepartmentBudgetRequestDto dto) {

		DepartmentBudgetResponseDto response = budgetService.createBudget(dto);

		return new ResponseEntity<>(new ApiResponse<>(true, "Budget created successfully", response),
				HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<DepartmentBudgetResponseDto>>> getAllBudgets() {

		List<DepartmentBudgetResponseDto> response = budgetService.getAllBudgets();

		return ResponseEntity.ok(new ApiResponse<>(true, "Budgets fetched successfully", response));
	}

	@GetMapping("/summary")
	public ResponseEntity<ApiResponse<FinanceSummaryResponseDto>> getFinanceSummary(

			@RequestParam Department department,

			@RequestParam Integer month,

			@RequestParam Integer year) {

		FinanceSummaryResponseDto response = budgetService.getFinanceSummary(department, month, year);

		return ResponseEntity.ok(new ApiResponse<>(true, "Summary fetched successfully", response));
	}
}