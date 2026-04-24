package com.mayank.assignment.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.mayank.assignment.model.TestNamingPractice;

class TestNamingPracticeTest {
	
	TestNamingPractice testNamingPractice = new TestNamingPractice(1000);

	@Test
	public void testShouldReturnUpdatedBalanceWhenDepositIsSuccessful() {
		testNamingPractice.deposite(200);
		testNamingPractice.withdraw(500);
		assertEquals(700, testNamingPractice.getBalance());
	}

}
