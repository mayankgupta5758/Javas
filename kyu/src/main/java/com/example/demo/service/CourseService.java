package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseRequestDto;
import com.example.demo.dto.CourseResponseDto;
import com.example.demo.dto.PageResponseDTO;

@Service
public interface CourseService {

	public CourseResponseDto addCourse(CourseRequestDto course);

	public List<CourseResponseDto> addMoreCourse(List<CourseRequestDto> course);

	public CourseResponseDto getCourseById(int id);

	public List<CourseResponseDto> readAllCourse();

	public CourseResponseDto updateById(int id,  CourseRequestDto course);
	
	public CourseResponseDto updateByIdPatch(int id, Map<String, Object> map);
	
	public String deleteById(int id);
	
	PageResponseDTO<CourseResponseDto> getAllCoursesWithPagination(int pageNumber, int pageSize);
}
