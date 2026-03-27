package com.mayank.assignment.model;

public class Nurse extends Staff {
    private int shiftHours;
    public Nurse(int id, String name, String dept, int shiftHours, Status status) {
        super(id, name, dept, status);
        this.shiftHours = shiftHours;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Shift Hours: " + shiftHours);
        System.out.println();
    }
}