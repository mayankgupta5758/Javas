package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//emp_id
//emp_name
//emp_city
//city_code
//emp_salary
//emp_age
//emp_email (regex)

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	private int e_id;

	@Column(name = "e_name")
	private String name;

	@Column(name = "e_city")
	private String city;

	private int city_code;

	@Column(name = "e_salary")
	private double salary;

	@Column(name = "e_age")
	private int age;

	@Column(name = "e_email")
	private String email;

	public Employee(int e_id, String name, String city, int city_code, double salary, int age, String email) {
		this.e_id = e_id;
		this.name = name;
		this.city = city;
		this.city_code = city_code;
		this.salary = salary;
		this.age = age;
		this.email = email;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCity_code() {
		return city_code;
	}

	public void setCity_code(int city_code) {
		this.city_code = city_code;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", name=" + name + ", city=" + city + ", city_code=" + city_code + ", salary="
				+ salary + ", age=" + age + ", email=" + email + "]";
	}

}
