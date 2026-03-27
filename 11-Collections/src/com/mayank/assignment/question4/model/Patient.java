package com.mayank.assignment.question4.model;

import java.util.Objects;

public class Patient extends Hospital {
	protected int patientId;
	protected int token;protected PatientStatus status = null;

	public Patient(String name, int age, int patientId) {
		super(name, age);
		this.patientId = patientId;
	}
	
	public int getPatientID() {
		return patientId;
	}
	public int getToken() {
		return token;
	}
	public void setToken(int token) {
		this.token = token;
	}
	public PatientStatus getPatientStatus() {
		return status;
	}
	public void setPatientStatus(PatientStatus status) { 
		this.status = status;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Patient))
            return false;

        Patient b = (Patient) obj;
        return this.patientId == b.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

    @Override
    public String toString() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age;
    }

}
