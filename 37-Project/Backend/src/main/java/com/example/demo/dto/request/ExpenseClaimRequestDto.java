package com.example.demo.dto.request;

import java.time.LocalDate;

import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ExpenseClaimRequestDto {

	@NotBlank(message = "Employee name is required")
	@Size(min = 3, max = 50, message = "Employee name must be between 3 and 50 characters")
	private String employeeName;

	@NotNull(message = "Department is required")
	private Department department;

	@NotNull(message = "Expense category is required")
	private ExpenseCategory expenseCategory;

	@NotNull(message = "Amount is required")
	@Positive(message = "Amount must be greater than 0")
	private Double amount;

	@NotNull(message = "Expense date is required")
	private LocalDate expenseDate;

	@NotBlank(message = "Description is required")
	@Size(min = 5, max = 500, message = "Description must be between 5 and 500 characters")
	private String description;
}