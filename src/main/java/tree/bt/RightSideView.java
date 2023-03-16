package tree.bt;

import java.util.*;

public class RightSideView {
    public List<Integer> rightSideView(BTNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) {
            return view;
        }
        Queue<BTNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 记录上一层节点个数
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                BTNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                // 加入每层最后一个节点
                if (i == n - 1) {
                    view.add(curr.val);
                }
            }
        }
        return view;
    }
}
