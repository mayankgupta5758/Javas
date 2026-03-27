package com.mayank.assignment.question2.model;

public class PriorityOrder extends Order {
    private String priorityLevel;
    public PriorityOrder(int id, String name, double amount, String level) {
        super(id, name, amount);
        this.priorityLevel = level;
    }

    @Override
    public String toString() {
        return super.toString() + " | Priority: " + priorityLevel;
    }
}