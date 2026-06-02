package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

//A custom repository interface (StudentRepository in this case) in Spring Data JPA
//allows us to define additional query methods or business logic beyond the standard
//CRUD operations.
//It extends "JpaRepository" and provides a way to implement complex or specialized
//database operations.
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}
