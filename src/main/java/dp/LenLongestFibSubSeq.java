package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #837 (Medium)
 * @author binqibang
 * @date 2022/7/9
 */
public class LenLongestFibSubSeq {
    /**
     * 枚举斐波那契前两个元素，哈希表查找是否存在第三元素
     * <br>
     * Time: O(n^2); Space: O(n)
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int ans = 0;
        // 哈希表查找复杂度O(1)
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, val);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num1 = arr[i];
                int num2 = arr[j];
                int count = 2;
                while (map.containsKey(num1 + num2)) {
                    count++;
                    int tmp = num1 + num2;
                    num1 = num2;
                    num2 = tmp;
                }
                if (count >= 3) {
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    /**
     * dp[j][i]：以arr[j]、arr[i]结尾的斐波那契的最长长度,
     * 遍历寻找一个k, k < j，使得 arr[k] < arr[j] < arr[i],
     * arr[i] - arr[j] = arr[k]
     */
    public int lenLongestFibSubseq1(int[] arr) {
        Map<Integer, Integer> indices = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int ans = 0;
        // 从后向前遍历
        for (int i = 0; i < n; i++) {
            // 只有当 arr[j] * 2 > arr[i] 时才满足 arr[k] < arr[j]
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                if (indices.containsKey(arr[i] - arr[j])) {
                    int k = indices.get(arr[i] - arr[j]);
                    dp[j][i] = dp[k][j] + 1;
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans >= 3 ? ans : 0;
    }
}
