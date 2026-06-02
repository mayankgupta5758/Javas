package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentRequestDto;
import com.example.demo.dto.DepartmentResponseDto;
import com.example.demo.dto.EmployeeRequestDto;
import com.example.demo.dto.PageResponseDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;

	@Override
	public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {

		if (departmentRepository.existsByDepartmentName(dto.getDepartmentName())) {

			throw new DuplicateResourceException("Department already exists with name : " + dto.getDepartmentName());
		}

		validateEmployeeEmailsForCreate(dto);

		Department department = modelMapper.map(dto, Department.class);

		attachEmployeesToDepartment(department);

		Department savedDepartment = departmentRepository.save(department);

		return modelMapper.map(savedDepartment, DepartmentResponseDto.class);
	}

	@Override
	public List<DepartmentResponseDto> getAllDepartments() {

		return departmentRepository.findAll().stream()
				.map(department -> modelMapper.map(department, DepartmentResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public PageResponseDto<DepartmentResponseDto> getAllDepartmentsWithPagination(int pageNumber, int pageSize) {

		validatePagination(pageNumber, pageSize);

		Pageable pageable = PageRequest.of(pageNumber, pageSize);

		Page<Department> page = departmentRepository.findAll(pageable);

		List<DepartmentResponseDto> content = page.getContent().stream()
				.map(department -> modelMapper.map(department, DepartmentResponseDto.class)).toList();

		PageResponseDto<DepartmentResponseDto> response = new PageResponseDto<>();

		response.setContent(content);
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalCount(page.getTotalElements());
		response.setTotalPage(page.getTotalPages());
		response.setLastPage(page.isLast());

		return response;
	}

	@Override
	public DepartmentResponseDto getDepartmentById(Long id) {

		Department department = findDepartmentById(id);

		return modelMapper.map(department, DepartmentResponseDto.class);
	}

	@Override
	public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto dto) {

		Department existingDepartment = findDepartmentById(id);

		if (departmentRepository.existsByDepartmentNameAndIdNot(dto.getDepartmentName(), id)) {

			throw new DuplicateResourceException("Department name already exists");
		}

		validateEmployeeEmailsForUpdate(dto);

		existingDepartment.setDepartmentName(dto.getDepartmentName());

		existingDepartment.setLocation(dto.getLocation());

		existingDepartment.getEmployees().clear();

		List<Employee> employees = dto.getEmployees().stream()
				.map(employeeDto -> modelMapper.map(employeeDto, Employee.class)).toList();

		employees.forEach(employee -> employee.setDepartment(existingDepartment));

		existingDepartment.getEmployees().addAll(employees);

		Department updatedDepartment = departmentRepository.save(existingDepartment);

		return modelMapper.map(updatedDepartment, DepartmentResponseDto.class);
	}

	@Override
	public void deleteDepartment(Long id) {

		Department department = findDepartmentById(id);

		departmentRepository.delete(department);
	}

	// ==================================
	// Helper Methods
	// ==================================

	private Department findDepartmentById(Long id) {

		return departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with id : " + id));
	}

	private void attachEmployeesToDepartment(Department department) {

		department.getEmployees().forEach(employee -> employee.setDepartment(department));
	}

	private void validateEmployeeEmailsForCreate(DepartmentRequestDto dto) {

		for (EmployeeRequestDto employee : dto.getEmployees()) {

			if (employeeRepository.existsByEmail(employee.getEmail())) {

				throw new DuplicateResourceException("Employee email already exists : " + employee.getEmail());
			}
		}
	}

	private void validateEmployeeEmailsForUpdate(DepartmentRequestDto dto) {

		for (EmployeeRequestDto employee : dto.getEmployees()) {

			if (employeeRepository.existsByEmail(employee.getEmail())) {

				throw new DuplicateResourceException("Employee email already exists : " + employee.getEmail());
			}
		}
	}

	private void validatePagination(int pageNumber, int pageSize) {

		if (pageNumber < 0) {
			throw new IllegalArgumentException("Page number cannot be negative");
		}

		if (pageSize <= 0) {
			throw new IllegalArgumentException("Page size must be greater than zero");
		}

		if (pageSize > 100) {
			throw new IllegalArgumentException("Page size cannot exceed 100");
		}
	}
}