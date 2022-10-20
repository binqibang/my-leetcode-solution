package dp;

/**
 * LeetCode #256 (Medium)
 * @author binqibang
 * @date 2022/6/25
 */
public class PaintHouse {
    /**
     * 由于此问题具有单调性，即`n`个房子的最低花费可以从 <br>
     * `n-1`个房子最低花费得出，使用动态规划算法 <br>
     * <br>
     * dp[i][j]: the minimum cost of painting i-th house to j-th color <br>
     * dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0], i > 0; ... <br>
     * <br>
     * Time: O(n); Space: O(n)
     * @param costs the cost of painting i-th house to j-th color
     * @return the minimum cost of painting all houses
     */
    public int minCost1(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        // 初始条件
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][1];
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    /**
     * 使用滚动数组降低空间复杂度<br>
     * Time: O(n); Space: O(1)
     * @param costs the cost of painting i-th house to j-th color
     * @return the minimum cost of painting all houses
     */
    public int minCost2(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[2][3];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[1][0] = Math.min(dp[0][1], dp[0][2]) + costs[i][0];
            dp[1][1] = Math.min(dp[0][0], dp[0][2]) + costs[i][1];
            dp[1][2] = Math.min(dp[0][0], dp[0][1]) + costs[i][2];
            // i-th 覆盖 (i-1)-th
            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
        }
        return Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]);
    }
}
