package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

	@NotBlank
	private String name;

	@Min(18)
	private int age;

	@NotBlank
	private String dept;

//	public StudentRequestDTO() {
//	}
//
//	public StudentRequestDTO(String name, int age, String dept) {
//		this.name = name;
//		this.age = age;
//		this.dept = dept;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getDept() {
//		return dept;
//	}
//
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
}