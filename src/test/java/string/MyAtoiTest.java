package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyAtoiTest {
    private MyAtoi atoi;

    @BeforeEach
    void setUp() {
        atoi = new MyAtoi();
    }

    @Test
    void myAtoi() {
        String s = "4193 with words";
        System.out.println(atoi.myAtoi(s));
    }
}