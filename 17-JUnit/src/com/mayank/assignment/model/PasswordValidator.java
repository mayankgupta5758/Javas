package com.mayank.assignment.model;

public class PasswordValidator {
	private String password;

	public PasswordValidator(String password) {
		if(password == null || password.trim().isEmpty()) {
			throw new IllegalArgumentException("Password Can't be null.");
		}
		if (password.length() < 8) {
			throw new IllegalArgumentException("Password at Least 8 Characters long.");
		}
		if (!hasUpperCase(password)) {
			throw new IllegalArgumentException("Password at Least 1 UpperCase Letter.");
		}
		if (!hasOneNumber(password)) {
			throw new IllegalArgumentException("Password at Least 1 Number.");
		}
		this.password = password;
	}

	public boolean hasUpperCase(String str) {
		return str != null && str.matches(".*[A-Z].*");
	}

	public boolean hasOneNumber(String str) {
		return str != null && str.matches(".*[0-9].*");
	}

	public String getPassword() {
		return password;
	}
}
