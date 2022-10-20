package hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumTest {
    private TwoSum ts;

    @BeforeEach
    void setUp() {
        ts = new TwoSum();
    }

    @Test
    void twoSum() {
        int[] nums = new int[] {2,7,11,15};
        int target = 13;
        var ans = ts.twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}