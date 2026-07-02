package com.example.demo.dto.response;

import java.time.LocalDate;

import com.example.demo.enums.ClaimStatus;
import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;

import lombok.Data;

@Data
public class ExpenseClaimResponseDto {

	private Long id;

	private String employeeName;

	private Department department;

	private ExpenseCategory expenseCategory;

	private Double amount;

	private LocalDate expenseDate;

	private String description;

	private ClaimStatus status;

	private String reviewRemark;
}