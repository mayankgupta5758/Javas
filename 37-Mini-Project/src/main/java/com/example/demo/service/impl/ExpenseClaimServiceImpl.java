package com.example.demo.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.ClaimReviewRequestDto;
import com.example.demo.dto.request.ExpenseClaimRequestDto;
import com.example.demo.dto.response.ExpenseClaimResponseDto;
import com.example.demo.entity.DepartmentBudget;
import com.example.demo.entity.ExpenseClaim;
import com.example.demo.enums.ClaimStatus;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositary.DepartmentBudgetRepository;
import com.example.demo.repositary.ExpenseClaimRepository;
import com.example.demo.service.ExpenseClaimService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseClaimServiceImpl implements ExpenseClaimService {

	private final ExpenseClaimRepository claimRepository;

	private final DepartmentBudgetRepository budgetRepository;

	private final ModelMapper modelMapper;

	@Override
	public ExpenseClaimResponseDto createClaim(ExpenseClaimRequestDto dto) {

		ExpenseClaim claim = modelMapper.map(dto, ExpenseClaim.class);

		claim.setStatus(ClaimStatus.PENDING);

		ExpenseClaim savedClaim = claimRepository.save(claim);

		return modelMapper.map(savedClaim, ExpenseClaimResponseDto.class);
	}

	@Override
	public List<ExpenseClaimResponseDto> getAllClaims() {

		return claimRepository.findAll().stream().map(claim -> modelMapper.map(claim, ExpenseClaimResponseDto.class))
				.toList();
	}

	@Override
	public ExpenseClaimResponseDto getClaimById(Long claimId) {

		ExpenseClaim claim = claimRepository.findById(claimId)
				.orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

		return modelMapper.map(claim, ExpenseClaimResponseDto.class);
	}

	@Override
	public ExpenseClaimResponseDto approveClaim(Long claimId, ClaimReviewRequestDto dto) {

		ExpenseClaim claim = claimRepository.findById(claimId)
				.orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

		if (claim.getStatus() != ClaimStatus.PENDING) {
			throw new RuntimeException("Only pending claims can be approved");
		}

		Integer month = claim.getExpenseDate().getMonthValue();

		Integer year = claim.getExpenseDate().getYear();

		DepartmentBudget budget = budgetRepository
				.findByDepartmentAndBudgetMonthAndBudgetYear(claim.getDepartment(), month, year)
				.orElseThrow(() -> new RuntimeException("Budget not found"));

		Double approvedExpense = claimRepository.getTotalApprovedExpense(claim.getDepartment(), month, year);

		Double newTotal = approvedExpense + claim.getAmount();

		if (newTotal > budget.getBudgetAmount()) {
			throw new RuntimeException("Department budget exceeded");
		}

		claim.setStatus(ClaimStatus.APPROVED);

		claim.setReviewRemark(dto.getReviewRemark());

		ExpenseClaim savedClaim = claimRepository.save(claim);

		return modelMapper.map(savedClaim, ExpenseClaimResponseDto.class);
	}

	@Override
	public ExpenseClaimResponseDto rejectClaim(Long claimId, ClaimReviewRequestDto dto) {

		ExpenseClaim claim = claimRepository.findById(claimId)
				.orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

		if (claim.getStatus() != ClaimStatus.PENDING) {
			throw new RuntimeException("Only pending claims can be rejected");
		}

		claim.setStatus(ClaimStatus.REJECTED);

		claim.setReviewRemark(dto.getReviewRemark());

		ExpenseClaim savedClaim = claimRepository.save(claim);

		return modelMapper.map(savedClaim, ExpenseClaimResponseDto.class);
	}
}