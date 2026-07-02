package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.DepartmentBudgetRequestDto;
import com.example.demo.dto.response.DepartmentBudgetResponseDto;
import com.example.demo.dto.response.FinanceSummaryResponseDto;
import com.example.demo.enums.Department;

public interface DepartmentBudgetService {

	DepartmentBudgetResponseDto createBudget(DepartmentBudgetRequestDto requestDto);

	List<DepartmentBudgetResponseDto> getAllBudgets();

	FinanceSummaryResponseDto getFinanceSummary(Department department, Integer month, Integer year);
}