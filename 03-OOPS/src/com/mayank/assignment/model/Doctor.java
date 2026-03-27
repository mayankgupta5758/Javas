package com.mayank.assignment.model;

public class Doctor extends Staff {
    private String specialization;
    public Doctor(int id, String name, String dept, String specialization, Status status) {
        super(id, name, dept, status);
        this.specialization = specialization;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Specialization: " + specialization);
        System.out.println();
    }
}