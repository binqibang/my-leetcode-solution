package dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxProductSubarrayTest {
    private MaxProductSubarray mp;

    @BeforeEach
    void setUp() {
        mp = new MaxProductSubarray();
    }

    @Test
    void maxProduct() {
        int[] nums = new int[] {2, 3, -2, 4};
        System.out.println(mp.maxProduct(nums));
    }
}