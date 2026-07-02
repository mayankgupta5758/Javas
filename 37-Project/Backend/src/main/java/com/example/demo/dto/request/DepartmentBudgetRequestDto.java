package com.example.demo.dto.request;

import com.example.demo.enums.Department;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DepartmentBudgetRequestDto {

	@NotNull(message = "Department is required")
	private Department department;

	@NotNull(message = "Month is required")
	@Min(value = 1, message = "Month must be between 1 and 12")
	@Max(value = 12, message = "Month must be between 1 and 12")
	private Integer budgetMonth;

	@NotNull(message = "Year is required")
	@Min(value = 2024, message = "Year must be valid")
	private Integer budgetYear;

	@NotNull(message = "Budget amount is required")
	@Positive(message = "Budget amount must be greater than 0")
	private Double budgetAmount;
}