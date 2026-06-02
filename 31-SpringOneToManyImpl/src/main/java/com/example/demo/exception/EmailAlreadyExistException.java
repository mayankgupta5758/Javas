package com.example.demo.exception;

public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String email) {
		super("Email Already Exist" + email);
	}
}
