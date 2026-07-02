package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.enums.ClaimStatus;
import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "expense_claims")
@Data
public class ExpenseClaim {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Employee name is required")
	private String employeeName;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Department is required")
	private Department department;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Expense category is required")
	private ExpenseCategory expenseCategory;

	@NotNull(message = "Amount is required")
	@Positive(message = "Amount must be greater than 0")
	private Double amount;

	@NotNull(message = "Expense date is required")
	private LocalDate expenseDate;

	@NotBlank(message = "Description is required")
	@Size(min = 5, max = 500)
	private String description;

	@Enumerated(EnumType.STRING)
	private ClaimStatus status = ClaimStatus.PENDING;

	private String reviewRemark;
}