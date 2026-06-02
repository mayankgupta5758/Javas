package com.example.demo.entity.exception;

public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String email) {
		super("Email Already Exist" + email);
	}
}
