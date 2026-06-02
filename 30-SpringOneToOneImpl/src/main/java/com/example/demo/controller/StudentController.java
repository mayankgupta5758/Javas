package com.example.demo.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.dto.PageResponseDto;
import com.example.demo.entity.dto.StudentRequestDto;
import com.example.demo.entity.dto.StudentResponseDto;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/create/add")
	public StudentResponseDto addStudent(@RequestBody StudentRequestDto student) {

		return studentService.createStudent(student);
	}
	
	@GetMapping("/get/id/{id}")
	public StudentResponseDto getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/get/readAll")
	public List<StudentResponseDto> getAllStudent() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/page")
	public PageResponseDto<StudentResponseDto> getAllStudentsWithPagination(
			@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "2") int pageSize) {
		return studentService.getAllStudentsWithPagination(pageNumber, pageSize);
	}
	
	@PutMapping("/update/put/{id}")
	public StudentResponseDto updateById(@PathVariable long id, @RequestBody StudentRequestDto student) {

		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {

		return studentService.deleteStudent(id);
	}
}
