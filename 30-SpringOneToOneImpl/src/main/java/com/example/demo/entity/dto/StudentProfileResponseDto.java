package com.example.demo.entity.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentProfileResponseDto {

	private Long id;

	@Column(unique = true)
	@NotNull(message = "Email can't be null")
	@Email(message = "Enter correct email Id")
	private String email;

	@NotNull(message = "Phone can't be null")
	private String phone;

	@NotNull(message = "City can't be null")
	private String city;
}
