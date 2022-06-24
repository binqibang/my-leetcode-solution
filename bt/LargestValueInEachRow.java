package bt;

import java.util.*;

/**
 * LeetCode #515
 * @author binqibang
 * @date 2022/6/24
 */
public class LargestValueInEachRow {
    /**
     * 层次遍历对于每层的特殊处理都可以套用如下模板<br>
     * Time: O(n); Space: O(n)
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            // 上一次入栈的结点数即为当前层长度
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                // 当前层每一个结点做处理
                var curr = queue.poll();
                max = Math.max(max, curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // 当前层遍历完
            res.add(max);
        }
        return res;
    }
}
