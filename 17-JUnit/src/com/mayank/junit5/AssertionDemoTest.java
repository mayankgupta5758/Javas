package com.mayank.junit5;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionDemoTest {

    @Test
    void testAssertions() {

        // 1. assertEquals
        assertEquals(5, 2 + 3);

        // 2. assertNotEquals
        assertNotEquals(6, 2 + 3);

        // 3. assertTrue
        assertTrue(10 > 5);

        // 4. assertFalse
        assertFalse(10 < 5);

        // 5. assertNull
        String str1 = null;
        assertNull(str1);

        // 6. assertNotNull
        String str2 = "Hello";
        assertNotNull(str2);

        // 7. assertSame
        String a = "Hi";
        String b = a;
        assertSame(a, b);

        // 8. assertNotSame
        String c = new String("Hi");
        String d = new String("Hi");
        assertNotSame(c, d);

        // 9. assertThrows
        assertThrows(ArithmeticException.class, () -> {
            int x = 10 / 0;
        });

        // 10. assertTimeout
        assertTimeout(Duration.ofSeconds(2), () -> {
            Thread.sleep(1000);
        });

        // 11. assertAll
        assertAll(
            () -> assertEquals(4, 2 + 2),
            () -> assertTrue(5 > 1),
            () -> assertNotNull("Test")
        );
    }
}