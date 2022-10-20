package weekly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Week315Test {
    private Week315 week315;

    @BeforeEach
    void setUp() {
        week315 = new Week315();
    }

    @Test
    void reverse() {
        long start = System.nanoTime();
        for (int i = 0; i < 1e8; i++) {
            week315.reverse(i);
        }
        long end  = System.nanoTime();
        System.out.println("reverse costs: " + (end - start) / 1e9 + " s");

        start = System.nanoTime();
        for (int i = 0; i < 1e8; i++) {
            week315.reverse1(i);
        }
        end  = System.nanoTime();
        System.out.println("reverse1 costs: " + (end - start) / 1e9 + " s");
    }
}