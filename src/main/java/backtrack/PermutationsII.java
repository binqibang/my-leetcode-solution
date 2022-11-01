package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #47 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/1
 */
public class PermutationsII {
    List<List<Integer>> ans;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int depth, List<Integer> perm) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 1. nums[i] is used
            // 2. nums[i-1] is the same num and not used
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }
            perm.add(nums[i]);
            used[i] = true;
            backtrack(nums, depth + 1, perm);
            used[i] = false;
            perm.remove(nums[i]);
        }
    }
}
