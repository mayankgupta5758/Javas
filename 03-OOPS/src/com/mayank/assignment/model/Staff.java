package com.mayank.assignment.model;

public class Staff {
    private int id;
    private String name;
    private String department;
    Status status;

    public Staff(int id, String name, String department, Status status) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.status = status;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Status: " + status);
    }
    
    public boolean isFree(String status) {
    	return status == "FREE";
    }
}