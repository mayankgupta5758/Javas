package com.mayank.assignment.model;

public class RegularStudent extends Student {

    private double fee;

    public RegularStudent(int id, String name, String course, double fee) {
        super(id, name, course);
        this.fee = fee;
    }

    @Override
    public void display() {

        super.display();
        System.out.println("Student Type: Regular");
        System.out.println("Fee: " + fee);
        System.out.println();
    }
}
