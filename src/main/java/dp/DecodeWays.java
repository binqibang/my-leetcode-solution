package dp;

/**
 * LeetCode #91 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/2
 */
public class DecodeWays {
    /**
     * dp[i] is the decode ways of s[i], dp[0] = 1 (empty string has one decode way);
     * dp[i] += dp[i-1], when s[i] != '0';
     * dp[i] += dp[i-2], when s[i-1] != '0' and (s[i-1]. s[i]) <= 26
     * @param s containing letters from A-Z.
     * @return the number of ways to decode it.
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int idx = i - 1;
            if (s.charAt(idx) != '0') {
                dp[i] += dp[i-1];
            }
            if (i > 1 && s.charAt(idx-1) != '0' && Integer.parseInt(s.substring(idx-1, idx+1)) <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
