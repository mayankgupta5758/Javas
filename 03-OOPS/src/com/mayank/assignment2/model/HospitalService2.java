package com.mayank.assignment2.model;

public abstract class HospitalService2 implements ServiceValidation2 {

	public int serviceId;
	String patientName;
	double fee;

	static String hospitalName;

	static {
		hospitalName = "City Care Hospital";
		System.out.println("Hospital Configuration Loaded: " + hospitalName);
	}

	HospitalService2(int id, String name, double fee) throws InvalidServiceException2 {
		if (id <= 0)
			throw new InvalidServiceException2("Invalid Service ID");

		if (fee < 0)
			throw new InvalidServiceException2("Fee cannot be negative");

		this.serviceId = id;
		this.patientName = name;
		this.fee = fee;
		System.out.println("HospitalService Constructor Called");
	}

	public void display() {
		System.out.println("ID: " + serviceId + " Patient: " + patientName + " Fee: " + fee);
	}
}
