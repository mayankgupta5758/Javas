package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import com.mayank.assignment.model.BoundaryTesting;

class BoundaryTestingTest {

    BoundaryTesting bt = new BoundaryTesting();

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 99, 100})
    void shouldReturnTrueValidRange(double marks) {
        assertTrue(bt.isValidMarks(marks));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void shouldReturnFalseValidRange(double marks) {
        assertFalse(bt.isValidMarks(marks));
    }

}
