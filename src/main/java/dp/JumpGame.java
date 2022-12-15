package dp;

/**
 * LeetCode #55 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/15
 */
public class JumpGame {
    /**
     * 动态规划，`dp[i]`指遍历到`i`这里时，能跳跃的最长的距离，则：
     * dp[i] = max(dp[i-1], nums[i] + i)
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            // 第`i-1`步能够跳到的最远距离无法到达下一步
            if (dp[i-1] < i) {
                return false;
            }
            dp[i] = Math.max(dp[i-1], nums[i] + i);
        }
        return dp[n-1] >= n;
    }

    /**
     * 动态规划优化，由于`dp[i]`只与`dp[i-1]`有关，因此可以用一个变量
     * 表示当前所能跳到的最大距离
     */
    public boolean canJump1(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int maxDist = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxDist < i) {
                return false;
            }
            maxDist = Math.max(maxDist, nums[i] + i);
        }
        return true;
    }
}
