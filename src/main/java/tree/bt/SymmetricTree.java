package tree.bt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode #101 (Easy); HOT 100
 * @author binqibang
 * @date 2022/12/17
 */
public class SymmetricTree {
    public boolean isSymmetric(BTNode root) {
        return check(root, root);
    }

    /**
     * 解法一：递归
     * `p`指针和`q`指针一开始都指向`root`，随后`p`右移时，`q`左移，`p`左移时，`q`右移
     */
    private boolean check(BTNode p, BTNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    /**
     * 解法二：迭代
     * 引入队列，每次出队两个结点判断，将其左右子结点按相反的顺序插入队列中
     */
    public boolean isSymmetric1(BTNode root) {
        // `LinkedList`支持空元素，而`ArrayDeque`不支持
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root.left); queue.offer(root.right);
        while (!queue.isEmpty()) {
            BTNode l = queue.poll(), r = queue.poll();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null) {
                return false;
            }
            if (l.val != r.val) {
                return false;
            }
            queue.offer(l.left); queue.offer(r.right);
            queue.offer(l.right); queue.offer(r.left);
        }
        return true;
    }
}
