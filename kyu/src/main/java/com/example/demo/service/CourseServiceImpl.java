package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CourseRequestDto;
import com.example.demo.dto.CourseResponseDto;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repositary.CourseRepositary;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

	private final CourseRepositary courseRepositary;
	private final ModelMapper modelMapper;

	public Course dtoToCourse(CourseRequestDto dto) {

		Course course = new Course();
		course.setCourse_code(dto.getCourse_code());
		course.setCourse_name(dto.getCourse_name());
		course.setTeacher_name(dto.getTeacher_name());
		course.setStudent(dto.getStudent());
		return course;
	}

	@Override
	public CourseResponseDto addCourse(CourseRequestDto dto) {
	    Course course = dtoToCourse(dto);
	    courseRepositary.save(course);
	    return courseToDto(course);
	}

	public CourseResponseDto courseToDto(Course course) {
		CourseResponseDto dto = new CourseResponseDto();
		dto.setCourse_id(course.getCourse_id());
		dto.setCourse_code(course.getCourse_code());
		dto.setCourse_id(course.getCourse_id());
		dto.setTeacher_name(course.getTeacher_name());
		dto.setStudent(course.getStudent());
		dto.setCourse_name(course.getCourse_name());
		return dto;
	}

	@Override
	public List<CourseResponseDto> addMoreCourse(List<CourseRequestDto> course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseResponseDto getCourseById(int id) {

	    Course course = courseRepositary.findById(id)
	            .orElseThrow(() -> new RuntimeException("Course Not Found"));

	    return courseToDto(course);
	}

	@Override
	public List<CourseResponseDto> readAllCourse() {
		List<Course> list = courseRepositary.findAll();

		return list.stream().map(std -> courseToDto(std)).collect(Collectors.toList());
	}

	@Override
	public CourseResponseDto updateById(int id, CourseRequestDto course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseResponseDto updateByIdPatch(int id, Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResponseDTO<CourseResponseDto> getAllCoursesWithPagination(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
