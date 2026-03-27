package com.mayank.assignment2.model;

public class GeneralConsultation2 extends HospitalService2 {

	public GeneralConsultation2(int id, String name, double fee) throws InvalidServiceException2 {
		super(id, name, fee);
		System.out.println("General Consultation Constructor Called");
	}

	public boolean validateService() {
		return fee >= 100;
	}
}
