package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Week330Test {
    private Week330 week330;

    @BeforeEach
    void setUp() {
        week330 = new Week330();
    }

    @Test
    void monkeyMove() {
        System.out.println(week330.distinctIntegers(55));
    }

    @Test
    void countQuadruplets() {
        int[] nums = new int[]{1, 3, 4, 2, 5};
        week330.countQuadruplets(nums);
    }

    @Test
    void quickPow() {
        week330.quickPow(7, 10);
    }
}