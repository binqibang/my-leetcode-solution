package tree.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #113 (Medium)
 * @author binqibang
 * @date 2023/2/23
 */
public class PathSumII {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(BTNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    private void dfs(BTNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.remove(path.size() - 1);
    }
}
