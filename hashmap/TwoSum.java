package hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #1 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/10/18
 */
public class TwoSum {
    /**
     * Time: O(n); Space: O(n)
     * @return indices of the two numbers such that they add up to target
     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = indices.get(target - nums[i]);
            }
            indices.put(nums[i], i);
        }
        return ans;
    }
}
