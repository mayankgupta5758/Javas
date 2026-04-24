package com.mayank.assignment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.mayank.assignment.model.MultipleExceptionScenarios;

class MultipleExceptionScenariosTest {

    MultipleExceptionScenarios bankService = new MultipleExceptionScenarios();

    // amount > balance
    @Test
    void testShouldThrowExceptionWhenAmountExceedsBalance() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> bankService.withdraw(1000, 1500)
        );

        assertEquals("Insufficient balance.", ex.getMessage());
    }

    // amount ≤ 0
    @Test
    void testShouldThrowExceptionWhenAmountIsZeroOrNegative() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> bankService.withdraw(1000, 0)
        );

        assertEquals("Amount must be greater than zero.", ex.getMessage());
    }

    // Valid case
    @Test
    void shouldReturnRemainingBalanceWhenWithdrawalIsValid() {
        double result = bankService.withdraw(1000, 200);
        assertEquals(800, result);
    }
}
