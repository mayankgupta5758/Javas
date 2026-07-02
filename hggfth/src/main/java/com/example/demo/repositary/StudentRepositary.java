package com.example.demo.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentRepositary extends JpaRepository<Student, Integer>{

	List<Student> getByName(String name);
}
