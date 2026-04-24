package com.mayank.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("JUnit 5 Full Annotation Demo")
class DemoTest {

    // 🔹 Before all tests
    @BeforeAll
    void initAll() {
        System.out.println("Before All Tests");
    }

    // 🔹 After all tests
    @AfterAll
    void tearDownAll() {
        System.out.println("After All Tests");
    }

    // 🔹 Before each test
    @BeforeEach
    void init() {
        System.out.println("Before Each Test");
    }

    // 🔹 After each test
    @AfterEach
    void tearDown() {
        System.out.println("After Each Test");
    }

    // 🔹 Basic Test
    @Test
    @Order(1)
    @DisplayName("Simple Addition Test")
    void testAddition() {
        int result = 2 + 3;
        Assertions.assertEquals(5, result);
    }

    // 🔹 Disabled Test
    @Test
    @Disabled("Not implemented yet")
    void skippedTest() {
        Assertions.fail("This test should not run");
    }

    // 🔹 Repeated Test
    @RepeatedTest(3)
    void repeatTest() {
        System.out.println("Running repeated test");
    }

    // 🔹 Timeout Test
    @Test
    @Timeout(2)
    void timeoutTest() throws InterruptedException {
        Thread.sleep(1000);
    }

    // 🔹 Parameterized Test (ValueSource)
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithValues(int num) {
        Assertions.assertTrue(num > 0);
    }

    // 🔹 Parameterized Test (CSV)
    @ParameterizedTest
    @CsvSource({
        "2,3,5",
        "3,4,7"
    })
    void testWithCSV(int a, int b, int result) {
        Assertions.assertEquals(result, a + b);
    }

    // 🔹 Parameterized Test (MethodSource)
    @ParameterizedTest
    @MethodSource("dataProvider")
    void testWithMethodSource(int a, int b, int result) {
        Assertions.assertEquals(result, a + b);
    }

    static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of(1, 2, 3),
            Arguments.of(2, 3, 5)
        );
    }

    // 🔹 Nested Tests
    @Nested
    class InnerTests {

        @Test
        void nestedTest() {
            Assertions.assertTrue(true);
        }
    }

    // 🔹 Tag Example
    @Test
    @Tag("fast")
    void taggedTest() {
        Assertions.assertEquals(10, 5 + 5);
    }

    // 🔹 Exception Test
    @Test
    void exceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int x = 1 / 0;
        });
    }

    // 🔹 Assumption Test
    @Test
    void assumptionTest() {
        Assumptions.assumeTrue(5 > 1);
        Assertions.assertEquals(2, 1 + 1);
    }
}