package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mayank.assignment.model.UserClass;

class UserClassTest {

	UserClass user;

	@BeforeEach
	void setUp() {
		user = new UserClass("Mayank", 20);
		System.out.println("Setup done");
	}

	@AfterEach
	void tearDown() {
		user = null;
		System.out.println("Cleanup done");
	}

	@Test
	void testValidUser() {
		assertNotNull(user);
		assertEquals("Mayank", user.getName());
		assertEquals(20, user.getAge());
	}

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new UserClass(null, 20);
		});
	}

	@Test
	void testInvalidAge() {
		assertThrows(IllegalArgumentException.class, () -> {
			new UserClass("Mayank", -5);
		});
	}
}
