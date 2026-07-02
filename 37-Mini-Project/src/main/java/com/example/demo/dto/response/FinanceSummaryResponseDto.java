package com.example.demo.dto.response;

import com.example.demo.enums.Department;

import lombok.Data;

@Data
public class FinanceSummaryResponseDto {

	private Department department;

	private Integer month;

	private Integer year;

	private Double monthlyBudget;

	private Double approvedExpense;

	private Double pendingExpense;

	private Double remainingBudget;

	private Long approvedClaims;

	private Long pendingClaims;

	private Long rejectedClaims;
}