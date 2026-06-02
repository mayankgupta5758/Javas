package com.example.demo.entity.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequestDto {

	@NotNull(message = "Name Con't be null")
	private String name;

	@NotNull(message = "Age can't be null")
	@Min(18)
	private int age;
	
	@Valid
	@NotNull
	private StudentProfileRequestDto studentProfile;

}
