package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeeRequestDto {

    @NotBlank(message = "Employee name can't be empty")
    private String employeeName;

    @NotBlank(message = "Email can't be empty")
    @Email(message = "Enter valid email")
    private String email;

    @Positive(message = "Salary must be greater than 0")
    private Double salary;
}