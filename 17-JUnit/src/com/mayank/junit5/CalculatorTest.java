package com.mayank.junit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
//👉 Assertions (assertEquals, assertTrue, etc.) use karne ke liye

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//👉 Ek hi object use hoga poore test class ke liye
//👉 (warna har test ke liye naya object banta)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//👉 Tests ko order me run karne ke liye (@Order use hoga)

public class CalculatorTest {

    Calculator calc;

    // 🔹 Before all tests
    @BeforeAll
    void setupAll() {
        System.out.println("Start Testing...");
    }

    // 🔹 Before each test
    @BeforeEach
    void setup() {
        calc = new Calculator(); // object create
    }

    // 🔹 Basic test (method call)
    @Test
    @Order(1)
    void testAdd() {
        int result = calc.add(2, 3); // 👉 method call
        assertEquals(5, result);
    }

    // 🔹 Parameterized test
    @ParameterizedTest
    @CsvSource({
        "2,3,5",
        "4,5,9",
        "1,1,2"
    })
//    👉 Same test multiple inputs ke saath run hoga
//    👉 har row = ek test case
    
    void testAddMultiple(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b)); // 👉 method call
    }

    // 🔹 Exception test
    @Test
    void testDivideException() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0); // 👉 method call
        });
    }

    // 🔹 Boolean test
    @Test
    void testIsPositive() {
        assertTrue(calc.isPositive(5));  // 👉 method call
        assertFalse(calc.isPositive(-1));
    }

    // 🔹 Repeated test
    @RepeatedTest(3)
    void repeatTest() {
        assertEquals(4, calc.add(2, 2));
    }

    // 🔹 Timeout test
    @Test
    @Timeout(2)
    void timeoutTest() throws InterruptedException {
        Thread.sleep(500);
        assertEquals(6, calc.add(3, 3));
    }

    // 🔹 Disabled test
    @Test
    @Disabled("Not needed now")
    void skipTest() {
        assertEquals(0, calc.add(0, 0));
    }

    // 🔹 After each
    @AfterEach
    void tearDown() {
        System.out.println("Test Done");
    }

    // 🔹 After all
    @AfterAll
    void tearDownAll() {
        System.out.println("All Tests Completed");
    }
}