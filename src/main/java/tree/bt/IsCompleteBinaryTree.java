package tree.bt;

import java.util.Deque;
import java.util.LinkedList;

public class IsCompleteBinaryTree {
    public boolean isCompleteBinaryTree(BTNode root) {
        if (root == null) {
            return true;
        }
        Deque<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            BTNode curr = queue.poll();
            // 叶节点之后所有节点都应是叶节点
            if (isLeaf && (curr.left != null || curr.right != null)) {
                return false;
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            } else if (curr.right != null) {
                // 左子树为空，但右子树不为空，一定不是完全二叉树
                return false;
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            } else if (curr.left == null){
                // 标记为叶子节点
                isLeaf = true;
            }
        }
        return true;
    }
}
