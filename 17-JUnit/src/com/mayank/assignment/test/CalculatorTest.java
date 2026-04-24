package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.mayank.assignment.model.Calculator;

class CalculatorTest {

	Calculator calc = new Calculator();

//	Add.

	@ParameterizedTest
	@CsvSource({
        "5,5,10",
        "-5,-5,-10",
        "5,-5,0"
    })
	public void testAddMixed(int a, int b, int res) {
		assertEquals(res, calc.add(a, b));
	}
	
//	@Test
//	public void testAddPositive() {
//		assertEquals(10, calc.add(5, 5));
//	}
//
//	@Test
//	public void testAddNegative() {
//		assertEquals(-10, calc.add(-5, -5));
//	}
//
//	@Test
//	public void testAddMixed() {
//		assertEquals(0, calc.add(5, -5));
//	}

	@Test
	public void testAddZero() {
		assertNotEquals(50, calc.add(0, 5));
	}

//	Subtract.
	
	@ParameterizedTest
	@CsvSource({
        "15,5,10",
        "-5,-5,0",
        "5,-5,10",
        "0,-5,5"
    })
	public void testSubtractMixed(int a, int b, int res) {
		assertEquals(res, calc.subtract(a, b));
	}

//	@Test
//	public void testSubtractPositive() {
//		assertEquals(10, calc.subtract(15, 5));
//	}
//
//	@Test
//	public void testSubtractNegative() {
//		assertEquals(0, calc.subtract(-5, -5));
//	}
//
//	@Test
//	public void testSubtractMixed() {
//		assertEquals(10, calc.subtract(5, -5));
//	}
//
//	@Test
//	public void testSubtractZero() {
//		assertEquals(5, calc.subtract(0, -5));
//	}

	@Test
	public void testSubtractZeroNotEqual() {
		assertNotEquals(15, calc.subtract(0, -5));
	}

//	Multiply.
	
	@ParameterizedTest
	@CsvSource({
        "5,5,25",
        "-5,-5,25",
        "5,-5,-25",
        "0,-5,0"
    })
	public void testMultiplyMixed(int a, int b, int res) {
		assertEquals(res, calc.multiply(a, b));
	}

//	@Test
//	public void testMultiplyPositive() {
//		assertEquals(25, calc.multiply(5, 5));
//	}
//
//	@Test
//	public void testMultiplyNegative() {
//		assertEquals(25, calc.multiply(-5, -5));
//	}
//
//	@Test
//	public void testMultiplyMixed() {
//		assertEquals(-25, calc.multiply(5, -5));
//	}
//
//	@Test
//	public void testMultiplyZero() {
//		assertEquals(0, calc.multiply(0, -5));
//	}

	@Test
	public void testMultiplyZeroNotEqual() {
		assertNotEquals(-5, calc.multiply(0, -5));
	}

//	Divide.
	
	@ParameterizedTest
	@CsvSource({
        "15,5,3",
        "-5,-5,1",
        "5,-5,-1",
        "0,-5,0"
    })
	public void testDivideMixed(int a, int b, int res) {
		assertEquals(res, calc.divide(a, b));
	}

//	@Test
//	public void testDividePositive() {
//		assertEquals(5, calc.divide(15, 3));
//	}
//
//	@Test
//	public void testDivideNegative() {
//		assertEquals(1, calc.divide(-5, -5));
//	}
//
//	@Test
//	public void testDivideMixed() {
//		assertEquals(-1, calc.divide(5, -5));
//	}

	@Test
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
	}

	@Test
	public void testDivideZeroNotEqual() {
		assertNotEquals(-5, calc.divide(0, -5));
	}
}
