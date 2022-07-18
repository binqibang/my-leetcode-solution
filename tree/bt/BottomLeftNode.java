package tree.bt;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode #513 (Medium)
 * @author binqibang
 * @date 2022/6/22
 */
public class BottomLeftNode {

    private int ans = 0;
    private int maxDepth = 0;

    /**
     * DFS模拟层次遍历<br>
     * Time: O(n); Space: O(n)
     * @param root
     * @return the leftmost value in the last row of the tree
     */
    public int findBottomLeftValue1(BTNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(BTNode root, int depth) {
        if (root == null) {
            return;
        }
        // 向下一层，深度+1
        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
        // 到达某子树最底层，记录当前深度和结点值
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }
    }


    /**
     * BFS，从右至左层次遍历<br>
     * Time: O(n); Space: O(n)
     * @param root
     * @return the leftmost value in the last row of the tree
     */
    public int findBottomLeftValue2(BTNode root) {
        int res = 0;
        Queue<BTNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BTNode curr = queue.poll();
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            res = curr.val;
        }
        return res;
    }
}
