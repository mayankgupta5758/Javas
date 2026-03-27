package com.mayank.assignment.question4.model;

import java.util.Objects;

public class Doctor extends Hospital{
	protected int doctorId;

	public Doctor(String name, int age, int doctorId) {
		super(name, age);
		this.doctorId = doctorId;
	}

	public int getDoctorID() {
		return doctorId;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Doctor))
            return false;

        Doctor b = (Doctor) obj;
        return this.doctorId == b.doctorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId);
    }

    @Override
    public String toString() {
        return "ID: " + doctorId + " | Name: " + name + " | Age: " + age;
    }

}
