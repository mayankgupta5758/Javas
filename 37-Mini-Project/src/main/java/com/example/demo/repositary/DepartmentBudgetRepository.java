package com.example.demo.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DepartmentBudget;
import com.example.demo.enums.Department;

public interface DepartmentBudgetRepository extends JpaRepository<DepartmentBudget, Long> {

	Optional<DepartmentBudget> findByDepartmentAndBudgetMonthAndBudgetYear(Department department, Integer budgetMonth,
			Integer budgetYear);

	boolean existsByDepartmentAndBudgetMonthAndBudgetYear(Department department, Integer budgetMonth,
			Integer budgetYear);
}