package tree.bt;

/**
 * LeetCode #437 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/23
 */
public class PathSumIII {
    int count = 0;

    public int pathSum(BTNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private void dfs(BTNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum) {
            count++;
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }

}
