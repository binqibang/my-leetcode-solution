package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #279 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/3
 */
public class NumSquares {
    /**
     * 方法一：降维完全背包
     * @TimeComplexity O(n*sqrt(n))
     * @SpaceComplexity O(n)
     */
    public int numSquares(int n) {
        // 预处理所有的完全平方数
        List<Integer> squares = new ArrayList<>();
        int s = 1;
        while (s * s <= n) {
            squares.add(s * s);
            s++;
        }
        // `dp[j]`指构成`j`的完全平方数最小个数
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        // 由`0`只能组成`0`
        dp[0] = 0;
        // 处理剩余情况
        for (int i = 1; i <= squares.size(); i++) {
            for (int j = squares.get(i-1); j <= n ; j++) {
                dp[j] = Math.min(dp[j], dp[j-squares.get(i-1)] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 方法二：将寻找完全平方数的过程合并
     * @TimeComplexity O(n*sqrt(n))
     * @SpaceComplexity O(n)
     */
    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i * i <= n ; i++) {
            int x = i * i;
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j-x] + 1);
            }
        }
        return dp[n];
    }
}
