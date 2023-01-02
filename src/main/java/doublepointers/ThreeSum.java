package doublepointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #15 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/24
 */
public class ThreeSum {
    /**
     * Time: O(n^2); Space: O(logn)
     * @return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
     *         and j != k, and nums[i] + nums[j] + nums[k] == 0.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // avoid same left num
                    while (j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    // avoid same right num
                    while (j < k && nums[k] == nums[k-1]){
                        k--;
                    }
                    // find new answer
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }
}
