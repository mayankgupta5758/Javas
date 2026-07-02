package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;

@Service
public interface StudentService {

	public StudentResponseDTO addStudent(StudentRequestDTO student);

	public List<StudentResponseDTO> addMoreStudent(List<StudentRequestDTO> student);

	public StudentResponseDTO getStudentById(int id);

	public List<StudentResponseDTO> readAllStudent();

	public StudentResponseDTO updateById(int id,  StudentRequestDTO student);
	
	public StudentResponseDTO updateByIdPatch(int id, Map<String, Object> map);
	
	public String deleteById( int id);
	
	PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(int pageNumber, int pageSize);
}
