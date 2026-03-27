package com.mayank.assignment.question7.model;

public abstract class Participant implements Comparable<Participant> {
    protected int participantId;
    protected String name;
    protected String track;
    protected ParticipantStatus status;

    public Participant(int id, String name, String track) {
        this.participantId = id;
        this.name = name;
        this.track = track;
        this.status = ParticipantStatus.REGISTERED;
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getName() {
        return name;
    }

    public String getTrack() {
        return track;
    }

    public ParticipantStatus getStatus() {
        return status;
    }

    public void setStatus(ParticipantStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return participantId + " | " + name + " | " + track + " | " + status;
    }

    @Override
    public int compareTo(Participant p) {
        return this.participantId - p.participantId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Participant)) return false;
        Participant p = (Participant) obj;
        return this.participantId == p.participantId;
    }

    @Override
    public int hashCode() {
        return participantId;
    }
}