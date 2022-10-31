package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode #39 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/31
 */
public class CombinationSum {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(candidates, target, new Stack<>(), 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, Stack<Integer> path, int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.push(candidates[i]);
                backtrack(candidates, target - candidates[i], path, i);
                path.pop();
            }
        }
    }
}
