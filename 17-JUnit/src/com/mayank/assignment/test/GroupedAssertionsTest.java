package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.mayank.assignment.model.GroupedAssertions;

class GroupedAssertionsTest {

	GroupedAssertions groupedAssertions;

	@Test
	public void testMultipleCondition() {
		assertAll("Multiple Condition for test.", () -> {
			IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
					() -> new GroupedAssertions("Kava", -21, "H2R"));
			assertEquals("age can't be Negative.", ex.getMessage());
		}, () -> {
			IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
					() -> new GroupedAssertions(null, -21, "H2R"));
			assertEquals("Name can't be Empty.", ex.getMessage());
		});
	}
}
