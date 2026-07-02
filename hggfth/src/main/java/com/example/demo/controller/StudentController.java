package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/create/add")
	public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO student) {

		return studentService.addStudent(student);
	}

	@PostMapping("/create/addMore")
	public List<StudentResponseDTO> addMoreStudent(@RequestBody List<StudentRequestDTO> student) {

		return studentService.addMoreStudent(student);
	}

	@GetMapping("/get/id/{id}")
	public StudentResponseDTO getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

//		List<Student> std = studentRepositary.getByName(name).orElseThrow(() -> 
//		new StudentNotFoundException(id));
//		list ke pass ye orElseThrough nahi hota keval optional ke pass hi hota hai.

	@GetMapping("/get/readAll")
	public List<StudentResponseDTO> readAllStudent() {

		return studentService.readAllStudent();
	}

	@PutMapping("/update/put/{id}")
	public StudentResponseDTO updateById(@PathVariable int id, @RequestBody StudentRequestDTO student) {

		return studentService.updateById(id, student);
	}

	@PatchMapping("/update/patch/{id}")
	public StudentResponseDTO updateByIdPatch(@PathVariable int id, @RequestBody Map<String, Object> map) {

		return studentService.updateByIdPatch(id, map);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {

		return studentService.deleteById(id);
	}

	@GetMapping("/page")
	public PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(
			@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "2") int pageSize) {
		return studentService.getAllStudentsWithPagination(pageNumber, pageSize);
	}
}
