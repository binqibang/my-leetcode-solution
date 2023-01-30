package weekly;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * LeetCode Weekly-Contest-330
 * @author binqibang
 * @date 2023/1/29
 */
public class Week330 {
    /**
     * <a href="https://leetcode.cn/problems/count-distinct-numbers-on-board/">6337. 统计桌面上的不同数字</a>
     * <br>
     * n % (n-1) = 1, (n-1) % (n-2) = 1, ..., 3 % 2 = 1, 2 % 1 = 0, finally we got 2 ~ n.
     */
    public int distinctIntegers(int n) {
        if (n == 1) {
            return 1;
        }
        return n - 1;
    }

    final int MOD = 1000000007;

    /**
     * <a href="https://leetcode.cn/problems/count-collisions-of-monkeys-on-a-polygon/">6338. 猴子碰撞的方法数</a>
     */
    public int monkeyMove(int n) {
        long total = quickPow(2, n);
        return (int) ((total + MOD - 2) % MOD);
    }

    public int monkeyMove1(int n) {
        return (BigInteger.TWO.modPow(
                BigInteger.valueOf(n), BigInteger.valueOf(MOD)
        ).intValue() + MOD - 2) % MOD;
    }

    /**
     * 快速幂算法
     */
    public long quickPow(int x, int n){
        long res = 1, cur = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * cur) % MOD;
            }
            cur = (cur * cur) % MOD;
            n = n >> 1;
        }
        return res;
    }

    /**
     * <a href="https://leetcode.cn/problems/put-marbles-in-bags/">6339. 将珠子放入背包中</a>
     * <br>
     * 将 weights 划分为 k 个连续子数组: w0, w1 w2, w3 w4, ..., w_n-2 w_n-1，
     * score = w0 + w_n-1 + SUM(1, k-1) w_i + w_i+1，计算间隙和数组，最大值和最小值差值即
     * 数组中前 k-1 个最大值和最小值的差
     */
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] scores = new long[n-1];
        for (int i = 1; i < n; i++) {
            scores[i-1] = weights[i-1] + weights[i+1];
        }
        Arrays.sort(scores);
        long min = 0L, max = 0L;
        for (int i = 0; i < k - 1; i++) {
            min += scores[i];
            // scores length: n - 1
            max += scores[n-2-i];
        }
        return max - min;
    }

    /**
     * <a href="https://leetcode.cn/problems/count-increasing-quadruplets/">6340. 统计上升四元组</a>
     */
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        // 统计下标 k 右边比 nums[j] 大的元素个数，即 greater[k][nums[j]]
        int[][] greater = new int[n][n+1];
        for (int k = n - 2; k > 0; k--) {
            greater[k] = greater[k+1].clone();
            // 对于 nums[k+1]，0 ~ nums[k+1]-1 下标计数加一
            for (int x = nums[k+1] - 1; x > 0; x--) {
                greater[k][x]++;
            }
        }
        long ans = 0;
        // 统计下标 j 左边比 nums[k] 小的元素个数，即 less[j][nums[k]]，
        // 由于正序遍历，这里采用滚动数组累加
        int[] less = new int[n+1];
        for (int j = 1; j < n - 2; j++) {
            for (int x = nums[j-1] + 1; x <= n; x++) {
                // 对于 nums[j-1]，nums[j-1]+1 ~ n 下标计数加一
                less[x]++;
            }
            for (int k = j + 1; k < n - 1; k++) {
                if (nums[j] > nums[k]) {
                    ans += (long) less[nums[k]] * greater[k][nums[j]];
                }
            }
        }
        return ans;
    }
}
