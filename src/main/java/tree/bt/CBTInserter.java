package tree.bt;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode #919 (Medium)
 * @author binqibang
 * @date 2022/7/25
 */
public class CBTInserter {
    Queue<BTNode> candidate;
    BTNode root;

    public CBTInserter(BTNode root) {
        candidate = new ArrayDeque<>();
        this.root = root;
        Queue<BTNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 将初始二叉树结点进行层序遍历，将可插入结点加入候选队列，
        // 可插入结点：左子树为空或右子树为空。
        while (!queue.isEmpty()) {
            BTNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left == null || node.right == null) {
                candidate.offer(node);
            }
        }
    }

    public int insert(int val) {
        BTNode child = new BTNode(val);
        BTNode cur = candidate.peek();
        if (cur.left == null) {
            cur.left = child;
        } else {
            // 插入到右子树后，该结点从候选队列移除
            cur.right = child;
            candidate.poll();
        }
        // 已插入节点加入候选队列
        candidate.offer(child);
        return cur.val;
    }

    public BTNode getRoot() {
        return root;
    }
}
