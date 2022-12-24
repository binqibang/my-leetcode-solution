package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode #139 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/22
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        // dp[i]: `s`的前`i`位是否可以用`wordDict`中的单词表示
        // dp[i] = dp[j] && check(j, i-1)
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
