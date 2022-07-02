package dp;

/**
 * LeetCode #871 (hard)
 * @author binqibang
 * @date 2022/7/2
 */
public class MinRefuelStops {
    /**
     * 动态规划，难点在于dp数组定义和更新，尤其更新过程需要双重循环<br>
     * Time: O(n^2); Space: O(n)
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        // dp[i]：加`i`次油能跑到的最大路程
        int[] dp = new int[n+1];
        // 未加油时，能跑的路程由初始油量决定
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                // 上一次加的油能跑到该加油站
                if (dp[j] >= stations[i][0]) {
                    dp[j+1] = Math.max(dp[j+1], dp[j] + stations[i][1]);
                }
            }
        }
        // 遍历数组，找到最先大于目标值的下标
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
