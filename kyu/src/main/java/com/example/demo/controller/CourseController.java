package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CourseRequestDto;
import com.example.demo.dto.CourseResponseDto;
import com.example.demo.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class CourseController {

	private final CourseService courseService;

	// Create Course
	@PostMapping
	public ResponseEntity<CourseResponseDto> addCourse(@RequestBody CourseRequestDto dto) {

		CourseResponseDto response = courseService.addCourse(dto);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Get All Courses
	@GetMapping
	public ResponseEntity<List<CourseResponseDto>> getAllCourses() {

		List<CourseResponseDto> courses = courseService.readAllCourse();

		return ResponseEntity.ok(courses);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable int id) {

		return ResponseEntity.ok(courseService.getCourseById(id));
	}
}