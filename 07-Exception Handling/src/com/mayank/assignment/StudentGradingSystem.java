package com.mayank.assignment;

public class StudentGradingSystem {

    public static void processStudent() throws InvalidMarksException {

        String name = null;  
        int marks = 120;     
        // Name validation
        if (name == null) {
            throw new NullPointerException("Student name cannot be null");
        }

        // Marks validation
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }

        System.out.println("Student: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Grade Assigned Successfully");
    }

    public static void main(String[] args) {

        try {
            processStudent();

        } catch (InvalidMarksException e) {
            System.out.println("Invalid Marks Error: " + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("Null Error: " + e.getMessage());

        } finally {
            System.out.println("Grading process completed");
        }
    }
}