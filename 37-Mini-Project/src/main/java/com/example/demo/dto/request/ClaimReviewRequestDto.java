package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClaimReviewRequestDto {

	@NotBlank(message = "Review remark is required")
	@Size(max = 500, message = "Remark cannot exceed 500 characters")
	private String reviewRemark;
}