package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.mayank.assignment.model.PasswordValidator;

class PasswordValidatorTest {

	PasswordValidator passwordValidator;

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { "", "      " })
	public void testPasswordWithNullString(String input) {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new PasswordValidator(input));
		assertEquals("Password Can't be null.", ex.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = { "sdsdD2", "mqqs1" })
	public void testPasswordWithLessThanEightCharaters(String input) {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new PasswordValidator(input));
		assertEquals("Password at Least 8 Characters long.", ex.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = { "sdsddwwf2", "1234556667" })
	public void testPasswordWithNoUpperCaseString(String input) {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new PasswordValidator(input));
		assertEquals("Password at Least 1 UpperCase Letter.", ex.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = { "SADFSFG@", "dasdwErd" })
	public void testPasswordWithNoLowerCaseString(String input) {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new PasswordValidator(input));
		assertEquals("Password at Least 1 Number.", ex.getMessage());
	}
}
