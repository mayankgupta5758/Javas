package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Student;

import lombok.Data;

@Data
public class CourseRequestDto {

private String course_name;
	
	private String teacher_name;
	
	private String course_code;

	private Student student;
}
