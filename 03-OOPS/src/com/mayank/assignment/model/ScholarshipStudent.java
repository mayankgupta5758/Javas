package com.mayank.assignment.model;

public class ScholarshipStudent extends Student {

    private double scholarshipAmount;

    public ScholarshipStudent(int id, String name, String course, double scholarshipAmount) {
        super(id, name, course);
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public void display() {

        super.display();
        System.out.println("Student Type: Scholarship");
        System.out.println("Scholarship Amount: " + scholarshipAmount);
        System.out.println();
    }
}