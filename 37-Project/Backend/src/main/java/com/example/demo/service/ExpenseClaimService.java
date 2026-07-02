package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.ClaimReviewRequestDto;
import com.example.demo.dto.request.ExpenseClaimRequestDto;
import com.example.demo.dto.response.ExpenseClaimResponseDto;

public interface ExpenseClaimService {

	ExpenseClaimResponseDto createClaim(ExpenseClaimRequestDto requestDto);

	List<ExpenseClaimResponseDto> getAllClaims();

	ExpenseClaimResponseDto getClaimById(Long claimId);

	ExpenseClaimResponseDto approveClaim(Long claimId, ClaimReviewRequestDto requestDto);

	ExpenseClaimResponseDto rejectClaim(Long claimId, ClaimReviewRequestDto requestDto);
}