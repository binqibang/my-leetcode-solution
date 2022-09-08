package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #560 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/8
 */
public class KSubarraySum {
    /**
     * 解法一：枚举所有的连续子数组。<br>
     * Time: O(n^2); Space: O(1)
     */
    public static int subarraySum(int[] nums, int k) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                // 即使和已经为 k，也不能退出循环，因为可能下一个元素为 0
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int subarraySum1(int[] nums, int k) {
        int ans = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,4,7,2,-3,1,4,2};
        int k = 7;
        int res = subarraySum(nums, k), res1 = subarraySum1(nums, k);
    }
}
