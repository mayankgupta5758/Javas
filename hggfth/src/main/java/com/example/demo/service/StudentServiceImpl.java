package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PageResponseDTO;
import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repositary.StudentRepositary;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepositary studentRepositary;

	@Autowired
	private ModelMapper modelMapper;

	public StudentServiceImpl(StudentRepositary studentRepositary) {
		this.studentRepositary = studentRepositary;
	}

	// DTO -> Entity
	public Student dtoToStudent(StudentRequestDTO studentDTO) {

		return this.modelMapper.map(studentDTO, Student.class);
	}

	// Entity -> DTO
	public StudentResponseDTO studentToDto(Student student) {

		return this.modelMapper.map(student, StudentResponseDTO.class);
	}

	@Override
	public StudentResponseDTO addStudent(StudentRequestDTO dto) {
		Student student = dtoToStudent(dto);
		Student savedStudent = studentRepositary.save(student);

		return studentToDto(savedStudent);
	}

	@Override
	public List<StudentResponseDTO> addMoreStudent(List<StudentRequestDTO> student) {
		List<Student> list = student.stream().map(std -> dtoToStudent(std)).collect(Collectors.toList());

		studentRepositary.saveAll(list);

		return list.stream().map(std -> studentToDto(std)).collect(Collectors.toList());
	}

	@Override
	public StudentResponseDTO getStudentById(int id) {
		Student stdent = studentRepositary.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		return studentToDto(stdent);
	}

	@Override
	public List<StudentResponseDTO> readAllStudent() {
		List<Student> list = studentRepositary.findAll();

		return list.stream().map(std -> studentToDto(std)).collect(Collectors.toList());
	}

	@Override
	public StudentResponseDTO updateById(int id, StudentRequestDTO exstudent) {
		Student student = dtoToStudent(exstudent);

		student = studentRepositary.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		student.setDept(exstudent.getDept());
		studentRepositary.save(student);

		return studentToDto(student);
	}

	@Override
	public StudentResponseDTO updateByIdPatch(int id, Map<String, Object> map) {

		Student student = studentRepositary.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		if (map.containsKey("dept")) {
			student.setDept((String) map.get("dept"));
		}
		studentRepositary.save(student);

		return studentToDto(student);
	}

	@Override
	public String deleteById(int id) {
		Student student = studentRepositary.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		studentRepositary.delete(student);
		return "delete success";
	}

	@Override
	public PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(int pageNumber, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

		Page<Student> studentPage = studentRepositary.findAll(pageRequest);
		List<Student> students = studentPage.getContent();

		List<StudentResponseDTO> studentResponseDTOs = students.stream().map(std -> (studentToDto(std)))
				.collect(Collectors.toList());
		
		PageResponseDTO<StudentResponseDTO> pageResponseDTO = new PageResponseDTO<>();
		
		pageResponseDTO.setContent(studentResponseDTOs);
		pageResponseDTO.setLastPage(studentPage.isLast());
		pageResponseDTO.setPageNumber(studentPage.getNumber());
		pageResponseDTO.setPageSize(studentPage.getSize());
		pageResponseDTO.setTotalCount(studentPage.getNumberOfElements());
		pageResponseDTO.setTotalPage(studentPage.getTotalPages());
		
		return pageResponseDTO;

	}
}
