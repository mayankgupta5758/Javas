package com.mayank.assignment.model;

public class Student {

    private int studentId;
    private String name;
    private String course;

    public Student(int studentId, String name, String course) {

        if(studentId <= 0)
            throw new IllegalArgumentException("Invalid Student ID");

        if(name == null || name.trim().length() < 2)
            throw new IllegalArgumentException("Invalid Name");

        if(course == null || course.trim().isEmpty())
            throw new IllegalArgumentException("Invalid Course");

        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}