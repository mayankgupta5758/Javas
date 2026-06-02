package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean addStudentDetails(Student std) {
		
		boolean status = false;
		try {
			studentRepository.save(std);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}

}
