package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #46 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/27
 */
public class Permutations {
    private List<List<Integer>> ans;
    boolean[] used; // if nums[i] is used

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        used = new boolean[nums.length];
        // current permutation
        List<Integer> perm = new ArrayList<>();
        // depth of recursion
        int depth = 0;
        backtrack(perm, depth, nums);
        return ans;
    }

    private void backtrack(List<Integer> perm, int depth, int[] nums) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                perm.add(nums[i]);
                used[i] = true;
                backtrack(perm, depth + 1, nums);
                // backtrack, revoke nums[i]
                used[i] = false;
                perm.remove(depth);
            }
        }
    }
}
