package dp;

/**
 * LeetCode #474 (Medium)
 * @author binqibang
 * @date 2022/7/10
 */
public class OnesZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int i = 1; i <= len; i++) {
            int zeros = countZeros(strs[i-1]);
            int ones = strs[i-1].length() - zeros;
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-zeros][k-ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= len ; i++) {
            int zeros = countZeros(strs[i-1]);
            int ones = strs[i-1].length() - zeros;
            for (int j = m; j >= zeros ; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int countZeros(String str) {
        int ans = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                ans++;
            }
        }
        return ans;
    }

}
