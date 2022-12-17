package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #78 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/16
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int[] nums,
                           int idx, List<Integer> subset) {
        // 这里对路径没有必须到叶节点的要求，因为子集长度不定
        ans.add(new ArrayList<>(subset));
        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            backtrack(ans, nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
