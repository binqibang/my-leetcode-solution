package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MySqrtTest {
    private MySqrt mySqrt;

    @BeforeEach
    void setUp() {
        mySqrt = new MySqrt();
    }

    @Test
    @Timeout(value = 1)
    void mySqrt() {
        for (int i = 0; i < 10000; i++) {
            Assertions.assertEquals((int) Math.sqrt(i), mySqrt.mySqrt(i));
        }
    }
}