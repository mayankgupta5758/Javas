package com.example.demo.entity;

import com.example.demo.enums.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "department_budgets", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "department", "budgetMonth", "budgetYear" }) })
@Data
public class DepartmentBudget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Department is required")
	private Department department;

	@NotNull(message = "Month is required")
	@Min(value = 1, message = "Month must be between 1 and 12")
	@Max(value = 12, message = "Month must be between 1 and 12")
	private Integer budgetMonth;

	@NotNull(message = "Year is required")
	private Integer budgetYear;

	@NotNull(message = "Budget amount is required")
	@Positive(message = "Budget amount must be greater than 0")
	private Double budgetAmount;
}