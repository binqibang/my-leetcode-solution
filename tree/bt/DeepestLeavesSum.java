package tree.bt;

import java.util.ArrayDeque;
import java.util.Queue;

public class DeepestLeavesSum {
    /**
     * 实际上此算法还可以得到最深一层的结点
     */
    public int deepestLeavesSum(BTNode root) {
        int sum = 0;
        Queue<BTNode> queue = new ArrayDeque<>();
        Queue<BTNode> curLevel = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            curLevel = new ArrayDeque<>(queue);
            for (int i = 0; i < curLevel.size(); i++) {
                var cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        System.out.print("Deepest level nodes: ");
        while (!curLevel.isEmpty()) {
            var node = curLevel.poll();
            System.out.printf("%d ", node.val);
            sum += node.val;
        }
        return sum;
    }
}
