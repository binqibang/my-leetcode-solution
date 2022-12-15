package dp;

/**
 * LeetCode #62 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/15
 */
public class UniquePaths {
    /**
     * 解法一：动态规划
     * @TimeComplexity O(mn)
     * @SpaceComplexity O(mn)
     */
    public int uniquePaths(int m, int n) {
        // dp[i][j]: 到达位置 (i, j) 的不同路径数，则：
        // dp[i][j] = dp[i-1][j]+ dp[i][j-1]
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 动态规划优化，一维滚动数组
     * @TimeComplexity O(mn)
     * @SpaceComplexity O(m)
     */
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[n-1];
    }

    /**
     * 解法二：组合数学
     * 到达点`(m-1,n-1)`需要移动`m+n-1`次，其中向下移动`m-1`次，则组合总数为`C(m-1)(m+n-1)`
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        // C(m-1)(m+n-1) = (m+n-2)! / (m-1)!(n-1)!
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
