package com.example.demo.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.DepartmentBudgetRequestDto;
import com.example.demo.dto.response.DepartmentBudgetResponseDto;
import com.example.demo.dto.response.FinanceSummaryResponseDto;
import com.example.demo.entity.DepartmentBudget;
import com.example.demo.enums.ClaimStatus;
import com.example.demo.enums.Department;
import com.example.demo.repositary.DepartmentBudgetRepository;
import com.example.demo.repositary.ExpenseClaimRepository;
import com.example.demo.service.DepartmentBudgetService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentBudgetServiceImpl implements DepartmentBudgetService {

	private final DepartmentBudgetRepository budgetRepository;

	private final ExpenseClaimRepository claimRepository;

	private final ModelMapper modelMapper;

	@Override
	public DepartmentBudgetResponseDto createBudget(DepartmentBudgetRequestDto dto) {

		boolean exists = budgetRepository.existsByDepartmentAndBudgetMonthAndBudgetYear(dto.getDepartment(),
				dto.getBudgetMonth(), dto.getBudgetYear());

		if (exists) {
			throw new RuntimeException("Budget already exists for this department and month");
		}

		DepartmentBudget budget = modelMapper.map(dto, DepartmentBudget.class);

		DepartmentBudget savedBudget = budgetRepository.save(budget);

		return modelMapper.map(savedBudget, DepartmentBudgetResponseDto.class);
	}

	@Override
	public List<DepartmentBudgetResponseDto> getAllBudgets() {

		return budgetRepository.findAll().stream()
				.map(budget -> modelMapper.map(budget, DepartmentBudgetResponseDto.class)).toList();
	}

	@Override
	public FinanceSummaryResponseDto getFinanceSummary(Department department, Integer month, Integer year) {

		DepartmentBudget budget = budgetRepository.findByDepartmentAndBudgetMonthAndBudgetYear(department, month, year)
				.orElseThrow(() -> new RuntimeException("Budget not found"));

		Double approvedExpense = claimRepository.getTotalApprovedExpense(department, month, year);

		Double pendingExpense = claimRepository.getTotalPendingExpense(department, month, year);

		Long approvedClaims = claimRepository.countByDepartmentAndStatus(department, ClaimStatus.APPROVED);

		Long pendingClaims = claimRepository.countByDepartmentAndStatus(department, ClaimStatus.PENDING);

		Long rejectedClaims = claimRepository.countByDepartmentAndStatus(department, ClaimStatus.REJECTED);

		FinanceSummaryResponseDto dto = new FinanceSummaryResponseDto();

		dto.setDepartment(department);
		dto.setMonth(month);
		dto.setYear(year);

		dto.setMonthlyBudget(budget.getBudgetAmount());

		dto.setApprovedExpense(approvedExpense);

		dto.setPendingExpense(pendingExpense);

		dto.setRemainingBudget(budget.getBudgetAmount() - approvedExpense);

		dto.setApprovedClaims(approvedClaims);

		dto.setPendingClaims(pendingClaims);

		dto.setRejectedClaims(rejectedClaims);

		return dto;
	}
}