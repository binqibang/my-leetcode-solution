package dp;

/**
 * LeetCode #198 (Medium)
 * @author binqibang
 * @date 2022/6/25
 */
public class HouseRobber {
    /**
     * DP三步法：
     * 1. 确定`dp[]`的含义；
     * 2. 确定初始值；
     * 3. 从初始值开始迭代，确定状态转移方程；
     * 4. 处理`dp[]`得到答案
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // dp[i]表示前i个房间偷到的最大宝藏数
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n == 1) {
            return dp[0];
        }
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            // 若选择i-th房间，dp[i] = dp[i-2]+ nums[i])
            // 若不选，dp[i] = dp[i-1]
            dp[i] = Math.max((dp[i-2]+ nums[i]), dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 1, 1, 2};
        System.out.println(rob(test));
    }
}
