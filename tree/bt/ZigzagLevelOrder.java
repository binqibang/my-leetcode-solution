package tree.bt;

import java.util.*;

/**
 * LeetCode #103 (Medium)
 * @author binqibang
 * @date 2022/9/9
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(BTNode root) {
        List<List<Integer>> order = new LinkedList<>();
        if (root == null) {
            return order;
        }
        Queue<BTNode> queue = new ArrayDeque<>();
        // if true, then from left to right
        boolean direction = true;
        queue.offer(root);
        Deque<Integer> row;
        while (!queue.isEmpty()) {
            row = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                BTNode cur = queue.poll();
                if (direction) {
                    row.offerLast(cur.val);
                } else {
                    row.offerFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            order.add(new LinkedList<>(row));
            direction = !direction;
        }
        return order;
    }

}
