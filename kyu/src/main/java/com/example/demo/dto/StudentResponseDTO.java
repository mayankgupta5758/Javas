package com.example.demo.dto;


import java.util.List;

import com.example.demo.entity.Course;

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
public class StudentResponseDTO {

	private int std_id;
	private String name;

	private int age;

	private String dept;
	
	 private List<Course> courses;
	 
//	public StudentResponseDTO() {
//	}
//
//	public StudentResponseDTO(String name, int age, String dept) {
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