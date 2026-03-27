package com.mayank.assignment.question4.model;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {

	@Override
	public int compare(Patient o1, Patient o2) {
		return Double.compare(o1.getPatientID(), o2.getPatientID());
	}

}
