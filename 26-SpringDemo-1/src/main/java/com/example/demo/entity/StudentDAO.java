package com.example.demo.entity;

import java.util.List;

public interface StudentDAO {

    public void save(Student theStudent);

    Student findById(Integer id);
    
    List<Student> readAllStudent();
}