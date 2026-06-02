package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentProfile;
import com.example.demo.entity.dto.PageResponseDto;
import com.example.demo.entity.dto.StudentProfileRequestDto;
import com.example.demo.entity.dto.StudentProfileResponseDto;
import com.example.demo.entity.dto.StudentRequestDto;
import com.example.demo.entity.dto.StudentResponseDto;
import com.example.demo.entity.exception.EmailAlreadyExistException;
import com.example.demo.entity.exception.StudentNotFoundException;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final StudentProfileRepository studentProfileRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Student dtoToStudent(StudentRequestDto studentDTO) {
		return this.modelMapper.map(studentDTO, Student.class);
	}

	public StudentResponseDto studentToDto(Student student) {
		return this.modelMapper.map(student, StudentResponseDto.class);
	}

	public StudentProfile dtoToStudentProfile(StudentProfileRequestDto studentProfileDTO) {
		return this.modelMapper.map(studentProfileDTO, StudentProfile.class);
	}

	public StudentProfileResponseDto studentProfileToDto(StudentProfile studentProfile) {
		return this.modelMapper.map(studentProfile, StudentProfileResponseDto.class);
	}

	public StudentResponseDto createStudent(StudentRequestDto requestDto) {
		Student student = dtoToStudent(requestDto);
		StudentProfile studentProfile = student.getStudentProfile();

		String email = studentProfile.getEmail();
		if (studentProfileRepository.existsByEmail(email)) {
			throw new EmailAlreadyExistException(email);
		}

		student.setStudentProfile(studentProfile);
		studentProfile.setStudent(student);
		studentRepository.save(student);

		return studentToDto(student);
	}

	public List<StudentResponseDto> getAllStudents() {
		List<Student> list = studentRepository.findAll();
		
		return list.stream().map(std -> studentToDto(std)).collect(Collectors.toList());
	}

	public PageResponseDto<StudentResponseDto> getAllStudentsWithPagination(int pageNumber, int pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

		Page<Student> studentPage = studentRepository.findAll(pageRequest);
		List<Student> students = studentPage.getContent();

		List<StudentResponseDto> studentResponseDTOs = students.stream().map(std -> (studentToDto(std)))
				.collect(Collectors.toList());
		
		PageResponseDto<StudentResponseDto> pageResponseDTO = new PageResponseDto<>();
		
		pageResponseDTO.setContent(studentResponseDTOs);
		pageResponseDTO.setLastPage(studentPage.isLast());
		pageResponseDTO.setPageNumber(studentPage.getNumber());
		pageResponseDTO.setPageSize(studentPage.getSize());
		pageResponseDTO.setTotalCount(studentPage.getNumberOfElements());
		pageResponseDTO.setTotalPage(studentPage.getTotalPages());
		
		return pageResponseDTO;
	}

	public StudentResponseDto getStudentById(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		return studentToDto(student);
	}

	public StudentResponseDto updateStudent(Long id, StudentRequestDto requestDto) {
		Student student = dtoToStudent(requestDto);

		student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		student.setAge(requestDto.getAge());
		studentRepository.save(student);

		return studentToDto(student);
	}

	public String deleteStudent(Long id) {
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		studentRepository.delete(student);
		return "delete success";
	}

	private StudentResponseDto findStudentById(Long id) {
		Student stdent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		return studentToDto(stdent);
	}

	private void updateProfile(StudentProfile profile, StudentProfileRequestDto profileRequestDto) {
	}

	private void validatePagination(int pageNumber, int pageSize) {
	}
}
