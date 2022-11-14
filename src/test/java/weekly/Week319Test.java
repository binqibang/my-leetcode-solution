package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Week319Test {
    private Week319 week319;

    @BeforeEach
    void setUp() {
        week319 = new Week319();
    }

    @Test
    void subarrayLCM() {
        int[] nums = new int[] {3,6,2,7,1};
        System.out.println(week319.subarrayLCM(nums, 6));
    }

    @Test
    void getGCD() {
        System.out.println(week319.getGCD(10, 15));
    }

    @Test
    void minSwaps() {
        int[] nums = new int[] {5, 7, 8, 6};
        System.out.println(week319.minSwaps(nums));
    }
}