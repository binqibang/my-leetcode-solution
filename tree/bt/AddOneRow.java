package tree.bt;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode #623 (Medium)
 * @author binqibang
 * @date 2022/8/5
 */
public class AddOneRow {
    /**
     * DFS，递归出口为 depth = 0,1,2 时 <br>
     * Time: O(n); Space: O(n)
     */
    public BTNode addOneRow(BTNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            return new BTNode(val, root, null);
        }
        if (depth == 2) {
            root.left = new BTNode(val, root.left, null);
            root.right = new BTNode(val, null, root.right);
        } else {
            root.left = addOneRow(root.left, val, depth-1);
            root.right = addOneRow(root.right, val, depth-1);
        }
        return root;
    }

    /**
     * BFS，需要遍历到 depth-2 层，让 depth-1 层结点全部入队 <br>
     * Time: O(n); Space: O(n)
     */
    public BTNode addOneRow1(BTNode root, int val, int depth) {
        if (depth == 1) {
            return new BTNode(val, root, null);
        }
        Queue<BTNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int curDepth = 1;
        // 全部 depth-1 层结点入队
        while (curDepth < depth - 1) {
            // 上一层结点数
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            curDepth++;
        }
        while (!queue.isEmpty()) {
            var node = queue.poll();
            node.left = new BTNode(val, node.left, null);
            node.right = new BTNode(val, null, node.right);
        }
        return root;
    }

}
