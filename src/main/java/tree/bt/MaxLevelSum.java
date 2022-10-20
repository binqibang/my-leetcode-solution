package tree.bt;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LeetCode #1161 (Medium)
 * @author binqibang
 * @date 2022/7/31
 */
public class MaxLevelSum {
    /**
     * 套用 BFS 每层处理的模板即可 <br>
     * Time: O(n); Space: O(n)
     */
    public int maxLevelSum(BTNode root) {
        int ans = 0, level = 0;
        int maxSum = -100000;
        Queue<BTNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int n = queue.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
        }
        return ans;
    }
}
