package dp;

import org.junit.jupiter.api.Test;

class MaxLengthOfLISTest {

    @Test
    void lengthOfLIS() {
        MaxLengthOfLIS maxLength = new MaxLengthOfLIS();
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        maxLength.lengthOfLIS(nums);
    }
}