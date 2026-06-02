package com.example.demo;

import java.util.List;

public interface EmployeeDAO {

	public void save(Employee nulla);
	
	Employee getById(int id);
	
	List<Employee> readAll();
	
	void updateById(int id);
	
	void deleteById(int id);
	
	List<Employee> readByName(String name);
	
	List<Employee> readByAge(int age);
	
	List<Employee> readByCitycode(int code);
	
	List<Employee> readBySalary();
}
