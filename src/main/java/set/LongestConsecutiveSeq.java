package set;

import java.util.Arrays;

/**
 * LeetCode #128 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/17
 */
public class LongestConsecutiveSeq {
    /**
     * 解法一：排序
     * @TimeComplexity O(nlogn)
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0, curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                curLen++;
                ans = Math.max(ans, curLen);
            } else if (nums[i] == nums[i-1]) {
                continue;
            } else {
                curLen = 1;
            }
        }
        return ans;
    }

}

