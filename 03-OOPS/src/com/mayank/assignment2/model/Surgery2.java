package com.mayank.assignment2.model;

public class Surgery2 extends HospitalService2 {

	public Surgery2(int id, String name, double fee) throws InvalidServiceException2 {
		super(id, name, fee);
		System.out.println("Surgery Constructor Called");
	}

	public boolean validateService() {
		return fee >= 5000;
	}
}