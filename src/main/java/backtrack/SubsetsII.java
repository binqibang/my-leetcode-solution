package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #90 (Medium)
 * @author binqibang
 * @date 2022/12/16
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] nums,
                           int idx, List<Integer> subset) {
        ans.add(new ArrayList<>(subset));
        for (int i = idx; i < nums.length; i++) {
            // 重复元素出现，剪枝
            if (i > idx && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            backtrack(ans, nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
