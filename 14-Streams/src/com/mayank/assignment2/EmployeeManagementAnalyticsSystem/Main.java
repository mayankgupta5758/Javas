package com.mayank.assignment2.EmployeeManagementAnalyticsSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		int n = UtilityFunction.getValidInt(sc, "Enter number of employees: ");
		
		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter details of Employee " + (i + 1));
			int id = UtilityFunction.getValidInt(sc, "ID: ");
			String name = UtilityFunction.getValidString(sc, "Name: ");
			String dept = UtilityFunction.getValidString(sc, "Department: ");
			double salary = UtilityFunction.getValidDouble(sc, "Salary: ");
			int exp = UtilityFunction.getValidInt(sc, "Experience (years): ");
			boolean active = UtilityFunction.getValidBoolean(sc, "Active (true/false): ");
			list.add(new Employee(id, name, dept, salary, exp, active));
		}

		System.out.println("\nActive Employees:");
		list.stream().filter(Employee::isActiveStatus).forEach(System.out::println);

		double threshold = UtilityFunction.getValidDouble(sc, "\nEnter salary threshold: ");
		System.out.println("Employees above threshold:");
		list.stream().filter(e -> e.getSalary() > threshold).forEach(System.out::println);

		System.out.println("\nCount by Department:");
		Map<String, Long> countDept = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(countDept);

		System.out.println("\nHighest Paid Employee:");
		list.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(System.out::println);

		System.out.println("\nNames sorted by salary (desc):");
		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getName)
				.forEach(System.out::println);

		System.out.println("\nGroup by Department:");
		Map<String, List<Employee>> grouped = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		grouped.forEach((k, v) -> {
			System.out.println(k + " -> " + v);
		});

		System.out.println("\nAverage Salary by Department:");
		Map<String, Double> avgSalary = list.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalary);
	}
}
