package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import com.mayank.assignment.model.DivisionException;

class DivisionExceptionTest {

	DivisionException divisionException = new DivisionException();

	@ParameterizedTest
	@CsvSource({ "3,0", "0,0", "100,0" })
	public void shouldThrowExceptionWhenDivisorIsZero(int a, int b) {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> divisionException.divide(a, b));

		assertEquals("Can't divide by Zero.", ex.getMessage());
	}

}
