package tree.bt;

import java.util.Deque;
import java.util.LinkedList;

/**
 * LeetCode #112 (Easy)
 * @author binqibang
 * @date 2023/2/23
 */
public class PathSum {
    public boolean hasPathSum(BTNode root, int targetSum) {
        if (root == null) {
            // 暂时返回 false
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum1(BTNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<BTNode> nodeQueue = new LinkedList<>();
        Deque<Integer> valQueue = new LinkedList<>();
        nodeQueue.offer(root); valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            BTNode curr = nodeQueue.poll();
            int sum = valQueue.poll();
            if (curr.left == null && curr.right == null) {
                if (sum == targetSum) {
                    return true;
                }
                continue;
            }
            if (curr.left != null) {
                nodeQueue.offer(curr.left);
                valQueue.offer(sum + curr.left.val);
            }
            if (curr.right != null) {
                nodeQueue.offer(curr.right);
                valQueue.offer(sum + curr.right.val);
            }
        }
        return false;
    }
}
