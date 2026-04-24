package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.mayank.assignment.model.BankAccount;

class BankAccountTest {

	BankAccount bankAccount;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("Sabse pehle ek baar chalega. beforeAll");
	}

	@BeforeEach
	public void beforeEach() {
		bankAccount = new BankAccount(1000);
		System.out.println("Har test ke baad chalega. beforeEach");
	}

	@ParameterizedTest
	@ValueSource(ints = { -1000, -1, -0 })
	public void testDepositeNegativeInput(double balance) {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> bankAccount.deposite(balance));
		assertEquals("can't deposite Negative amount.", ex.getMessage());
	}

//	@Test
//	public void testDepositeNegativeInput() {
//		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> bankAccount.deposite(-1000));
//		assertEquals("can't deposite Negative amount.", ex.getMessage());
//	}
//	
//	@Test
//	public void testDepositValid() {
//	    bankAccount.deposite(500);
//	    assertEquals(1500, bankAccount.getBalance());
//	}

	@Test
	public void testMultipleTransactions() {
		bankAccount.deposite(500);
		bankAccount.withdraw(200);
		assertEquals(1300, bankAccount.getBalance());
	}

	@Test
	public void testWithdrawNegativeInput() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-1000));
		assertEquals("can't withdraw Negative amount.", ex.getMessage());
	}

	@ParameterizedTest
	@CsvSource({ "300, 700", "2000, -1000" })
	public void testWithdrawMixed(double amount, double result) {
		bankAccount.withdraw(amount);
		assertEquals(result, bankAccount.getBalance());
	}
//	@Test
//	public void testWithdrawValid() {
//		bankAccount.withdraw(300);
//		assertEquals(700, bankAccount.getBalance());
//	}
//
//	@Test
//	public void testWithdrawMoreThanBalance() {
//		bankAccount.withdraw(2000);
//		assertEquals(-1000, bankAccount.getBalance());
//	}

	@AfterEach
	public void afterEach() {
		bankAccount = null;
		System.out.println("Har test ke baad chalega. afterEach");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("Sab test ke baad ek baar chalega. afterAll");
	}
}
