package dp;

import java.util.Arrays;

/**
 * LeetCode #494 (Medium)
 * @author binqibang
 * @date 2023/2/3
 */
public class TargetSum {
    /**
     * 转化为 01 背包问题
     */
    public int findTargetSumWays(int[] nums, int target) {
        // 设所有添加`+`的元素和为`A`，所有添加`-`的元素和为`B`，
        // 则 A + B = sum, A - B = target，联立得 A = (sum + target) / 2
        // 问题转化为 选择`nums`的元素使得元素和为`(sum + target) / 2`的方案数
        int sum = Arrays.stream(nums).sum();
        if (target > sum || sum < -target) {
            return 0;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int m = (sum + target) / 2;
        int[] dp = new int[m+1];
        // sum = -target，即所有元素全加`-`，方案数为1
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = m; j >= nums[i-1] ; j--) {
                dp[j] += dp[j- nums[i-1]];
            }
        }
        return dp[m];
    }
}
