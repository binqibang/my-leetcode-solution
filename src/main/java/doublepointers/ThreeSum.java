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
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // avoid same left num
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    // avoid same right num
                    while (l < r && nums[r] == nums[r-1]){
                        r--;
                    }
                    // find new answer
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
