package com.mayank.interfaces.model;

public interface PaymentGateway {
	void pay(double amount);

	void refund(double amount);
}
