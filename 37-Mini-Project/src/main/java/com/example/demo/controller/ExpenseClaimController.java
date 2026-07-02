package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.ClaimReviewRequestDto;
import com.example.demo.dto.request.ExpenseClaimRequestDto;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.ExpenseClaimResponseDto;
import com.example.demo.service.ExpenseClaimService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/claims")
@RequiredArgsConstructor
@Validated
@CrossOrigin("http://localhost:5173/")
public class ExpenseClaimController {

	private final ExpenseClaimService claimService;

	@PostMapping
	public ResponseEntity<ApiResponse<ExpenseClaimResponseDto>> createClaim(
			@Valid @RequestBody ExpenseClaimRequestDto dto) {

		ExpenseClaimResponseDto response = claimService.createClaim(dto);

		return new ResponseEntity<>(new ApiResponse<>(true, "Expense claim submitted successfully", response),
				HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<ApiResponse<List<ExpenseClaimResponseDto>>> getAllClaims() {

		List<ExpenseClaimResponseDto> response = claimService.getAllClaims();

		return ResponseEntity.ok(new ApiResponse<>(true, "Claims fetched successfully", response));
	}

	@GetMapping("/{claimId}")
	public ResponseEntity<ApiResponse<ExpenseClaimResponseDto>> getClaimById(@PathVariable Long claimId) {

		ExpenseClaimResponseDto response = claimService.getClaimById(claimId);

		return ResponseEntity.ok(new ApiResponse<>(true, "Claim fetched successfully", response));
	}

	@PutMapping("/{claimId}/approve")
	public ResponseEntity<ApiResponse<ExpenseClaimResponseDto>> approveClaim(@PathVariable Long claimId,
			@Valid @RequestBody ClaimReviewRequestDto dto) {

		ExpenseClaimResponseDto response = claimService.approveClaim(claimId, dto);

		return ResponseEntity.ok(new ApiResponse<>(true, "Claim approved successfully", response));
	}

	@PutMapping("/{claimId}/reject")
	public ResponseEntity<ApiResponse<ExpenseClaimResponseDto>> rejectClaim(@PathVariable Long claimId,
			@Valid @RequestBody ClaimReviewRequestDto dto) {

		ExpenseClaimResponseDto response = claimService.rejectClaim(claimId, dto);

		return ResponseEntity.ok(new ApiResponse<>(true, "Claim rejected successfully", response));
	}
}