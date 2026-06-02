package com.example.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentResponseDto {

	private long id;

	@JsonProperty("full_name")
	@NotNull(message = "Name Con't be null")
	private String name;

	@NotNull(message = "Age can't be null")
	@Min(18)
	private int age;

	private StudentProfileResponseDto studentProfile;
}
