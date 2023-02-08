package dp;

/**
 * LeetCode #300 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/3
 */
public class MaxLengthOfLIS {
    /**
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(n)
     */
    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示以第`i`个数字结尾的最长递增子序列长度
        // dp[i] = max(dp[j]) + 1, 0 <= j < i, nums[j] < nums[i]
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
