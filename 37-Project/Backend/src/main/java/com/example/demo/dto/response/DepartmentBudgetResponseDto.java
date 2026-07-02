package com.example.demo.dto.response;

import com.example.demo.enums.Department;

import lombok.Data;

@Data
public class DepartmentBudgetResponseDto {

    private Long id;

    private Department department;

    private Integer budgetMonth;

    private Integer budgetYear;

    private Double budgetAmount;
}