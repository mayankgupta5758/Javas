package com.mayank.assignment.question7.model;

public class RegularParticipant extends Participant {
    private String mode;
    public RegularParticipant(int id, String name, String track, String mode) {
        super(id, name, track);
        this.mode = mode;
    }

    @Override
    public String toString() {
        return super.toString() + " | Mode: " + mode;
    }
}