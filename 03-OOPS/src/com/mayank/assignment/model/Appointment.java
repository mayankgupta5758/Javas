package com.mayank.assignment.model;

public class Appointment {
	private int appointmentId;
	protected String patientName;
	protected String date;
	Doctor doctor;
	Nurse nurse;

	public Appointment(int appointmentId, String patientName, String date, Doctor doctor, Nurse nurse) {
		this.appointmentId = appointmentId;
		this.patientName = patientName;
		this.date = date;
		this.doctor = doctor;
		this.nurse = nurse;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void showAppointment() {
		
	}

	public void cancelAppointment() {

	}

	public void updateAppointment() {

	}

}
