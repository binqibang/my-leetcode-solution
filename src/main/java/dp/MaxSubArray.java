package dp;

/**
 * QUESTION: Given an integer array nums, find the contiguous subarray (containing at least one number)
 *           which has the largest sum and return its sum.
 * @author   binqibang
 * @created  2021/7/17
 */

public class MaxSubArray {
    /**
     * 优化后的动态规划
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int x:nums) {
            pre = Math.max(x, pre + x);
            res = Math.max(pre, res);
        }
        return res;
    }

    /**
     * 标准动态规划算法，dp[n]表示前 n+1 个元素最大子序列和 <br>
     * dp[0] = nums[0] <br>
     * dp[i] = dp[i-1]+nums[i] if select nums[i] <br>
     * dp[i] = nums[i] if not select nums[i]
     */
    public static int maxSubarray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubarray1(nums));
    }
}


