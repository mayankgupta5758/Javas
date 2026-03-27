package com.mayank.assignment.question7.model;

public class CorporateParticipant extends Participant {
    private String company;
    public CorporateParticipant(int id, String name, String track, String company) {
        super(id, name, track);
        this.company = company;
    }

    @Override
    public String toString() {
        return super.toString() + " | Company: " + company;
    }
}