package dp;

import java.util.Arrays;

/**
 * LeetCode #322 (Medium)
 * @author binqibang
 * @date 2022/7/10
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // 记录最佳方案
        int[][] flag = new int[coins.length][amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = coins[i-1]; j <= amount; j++) {
                if (dp[j] - 1 > dp[j-coins[i-1]]) {
                    dp[j] = dp[j-coins[i-1]] + 1;
                    flag[i-1][j] = 1;
                }
            }
        }
        int ans = dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        if (ans != -1) {
            // 输出最佳方案
            int idx = amount;
            while (idx > 0) {
                for (int i = coins.length - 1; i >= 0; i--) {
                    if (flag[i][idx] == 1) {
                        System.out.printf("%d ", coins[i]);
                        idx -= coins[i];
                        break;
                    }
                }
            }
            System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 2, 5};
        System.out.println(coinChange(test, 50));
    }
}
