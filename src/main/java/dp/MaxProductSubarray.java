package dp;

/**
 * LeetCode #152 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/3
 */
public class MaxProductSubarray {
    /**
     * 此类子数组问题往往用动态规划解决，如 {@link MaxSubArray}，<br>
     * 递推式：dp[i] = max(f(dp[i-1], nums[i]), nums[i]), dp[i]为最优子结构。<br>
     * 但本题并不适用，原因是负负可得正，dp[i]不是最优子结构。<br>
     * 这里我们可以维护两个 dp 数组，记录最大、最小子结构，再三者取其大，<br>
     * 即：dpMax[i] = max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i], nums[i])
     * @param nums a integer array
     * @return a contiguous non-empty subarray that has the largest product
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0]; dpMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i-1] * nums[i], Math.max(dpMin[i-1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i-1] * nums[i], Math.min(dpMin[i-1] * nums[i], nums[i]));
        }
        int ans = dpMax[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }

    public int maxProduct1(int[] nums) {
        int globalMin = nums[0], globalMax = nums[0];
        int ans = globalMax;
        for (int i = 1; i < nums.length; i++) {
            int preMin = globalMin, preMax = globalMax;
            globalMax = Math.max(preMax * nums[i], Math.max(preMin * nums[i], nums[i]));
            globalMin = Math.min(preMax * nums[i], Math.min(preMin * nums[i], nums[i]));
            ans = Math.max(ans, globalMax);
        }
        return ans;
    }
}
