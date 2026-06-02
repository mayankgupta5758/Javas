package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO) {
		return runner -> {
			createEmployee(employeeDAO);
			findById(employeeDAO);
			readAll(employeeDAO);
			updateById(employeeDAO);
//			deleteById(employeeDAO);
			readByName(employeeDAO);
			readByAge(employeeDAO);
			readByCityCode(employeeDAO);
			readBySalary(employeeDAO);
		};
	}

	private void readByCityCode(EmployeeDAO employeeDAO) {
		List<Employee> employee = employeeDAO.readByCitycode(85);
		System.out.println("Found Employee Search By City Code.");
		for (Employee e : employee) {
			System.out.println("Found the employee: " + e);
		}
	} 

	private void readBySalary(EmployeeDAO employeeDAO) {
		List<Employee> employee = employeeDAO.readBySalary();
		System.out.println("Found Employee Whose Salary is More Than 10000Rs.");
		for (Employee e : employee) {
			System.out.println("Found the employee: " + e);
		}
	}

	private void readByAge(EmployeeDAO employeeDAO) {
		List<Employee> employee = employeeDAO.readByAge(22);
		System.out.println("Found Employee Search By Age");
		for (Employee e : employee) {
			System.out.println("Found the employee: " + e);
		}
	}

	private void readByName(EmployeeDAO employeeDAO) {
		List<Employee> employee = employeeDAO.readByName("Samay");
		System.out.println("Found Employee Search By Name");
		for (Employee e : employee) {
			System.out.println("Found the employee: " + e);
		}
	}

	private void deleteById(EmployeeDAO employeeDAO) {
		System.out.println("Deleting employee");
		employeeDAO.deleteById(1);
		List<Employee> list = employeeDAO.readAll();

		for (Employee e : list) {
			System.out.println("Found the employee: " + e);
		}
		System.out.println("Employee deleted successfully.");
	}

	private void updateById(EmployeeDAO employeeDAO) {
		System.out.println("Updating employee Details");
		Employee e1 = employeeDAO.getById(1);
		System.out.println(e1);
		employeeDAO.updateById(1);
		Employee e2 = employeeDAO.getById(1);
		System.out.println(e2);
		System.out.println("Employee updated successfully");
	}

	private void readAll(EmployeeDAO employeeDAO) {
		System.out.println("Retrieving all student record from database");
		List<Employee> list = employeeDAO.readAll();

		for (Employee e : list) {
			System.out.println("Found the employee: " + e);
		}
	}

	private void createEmployee(EmployeeDAO employeeDAO) {
		System.out.println("Creating new employee object");
		Employee employee1 = new Employee(1, "Mayank", "Mathura", 85, 10000, 21, "mayank@gamil.com");
		Employee employee2 = new Employee(2, "Samay", "J&K", 25, 1000000, 28, "samay@gmail.com");
		Employee employee3 = new Employee(3, "Time", "Unknown", 2, 100000, 22, "time@gmail.com");
		System.out.println("Saving employee record");
		employeeDAO.save(employee1);
		employeeDAO.save(employee2);
		employeeDAO.save(employee3);
		System.out.println("Saved employee");
	}

	private void findById(EmployeeDAO employeeDAO) {
		System.out.println("Retrieving employee record from database");
		Employee foundEmployee = employeeDAO.getById(1);
		System.out.println("Found the employee: " + foundEmployee);
	}

}
