package doublepointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThreeSumTest {
    private ThreeSum ts;

    @BeforeEach
    void setUp() {
        ts = new ThreeSum();
    }

    @Test
    void threeSum() {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(ts.threeSum(nums));
    }
}