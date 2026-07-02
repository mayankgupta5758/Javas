package com.example.demo.repositary;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ExpenseClaim;
import com.example.demo.enums.ClaimStatus;
import com.example.demo.enums.Department;
import com.example.demo.enums.ExpenseCategory;

public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Long> {

	List<ExpenseClaim> findByDepartment(Department department);

	List<ExpenseClaim> findByStatus(ClaimStatus status);

	List<ExpenseClaim> findByExpenseCategory(ExpenseCategory expenseCategory);

	List<ExpenseClaim> findByDepartmentAndStatus(Department department, ClaimStatus status);

	List<ExpenseClaim> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);

	List<ExpenseClaim> findByDepartmentAndExpenseDateBetween(Department department, LocalDate startDate,
			LocalDate endDate);

	long countByStatus(ClaimStatus status);

	@Query("""
			SELECT COALESCE(SUM(ec.amount),0)
			FROM ExpenseClaim ec
			WHERE ec.department = :department
			AND ec.status = 'APPROVED'
			AND MONTH(ec.expenseDate) = :month
			AND YEAR(ec.expenseDate) = :year
			""")
	Double getTotalApprovedExpense(@Param("department") Department department, @Param("month") Integer month,
			@Param("year") Integer year);

	@Query("""
			SELECT COALESCE(SUM(ec.amount),0)
			FROM ExpenseClaim ec
			WHERE ec.department = :department
			AND ec.status = 'PENDING'
			AND MONTH(ec.expenseDate) = :month
			AND YEAR(ec.expenseDate) = :year
			""")
	Double getTotalPendingExpense(@Param("department") Department department, @Param("month") Integer month,
			@Param("year") Integer year);

	Long countByDepartmentAndStatus(Department department, ClaimStatus status);
}