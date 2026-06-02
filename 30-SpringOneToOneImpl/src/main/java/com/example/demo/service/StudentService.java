package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.dto.PageResponseDto;
import com.example.demo.entity.dto.StudentRequestDto;
import com.example.demo.entity.dto.StudentResponseDto;

@Service
public interface StudentService {

	StudentResponseDto createStudent(StudentRequestDto requestDto);

	List<StudentResponseDto> getAllStudents();

	PageResponseDto<StudentResponseDto> getAllStudentsWithPagination(int pageNumber, int pageSize);

	StudentResponseDto getStudentById(Long id);

	StudentResponseDto updateStudent(Long id, StudentRequestDto requestDto);

	String deleteStudent(Long id);
}
