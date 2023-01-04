package dp;

/**
 * LeetCode #221 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/16
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int m = matrix.length, n = matrix[0].length;
        // `dp[i][j]`表示以`(i, j)`为右下角且只包含`1`的正方形最大边长
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 边界上的点只能以自身构成正方形
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
