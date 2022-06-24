package segtree;

/**
 * SegmentTree
 * @date 2022/6/20
 * @reference <a href="https://lfool.github.io/LFool-Notes/algorithm/线段树详解.html">SegmentTreeDynamic</a>
 */
public class SegmentTree {
    class Node {
        Node left, right;
        int val;
        // lazy flag
        int lazy;
    }

    private void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    private void pushDown(Node node, int leftNum, int rightNum) {
        // 动态开点
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        // 如果`lazy`为 0，表示没有标记
        if (node.lazy == 0) {
            return ;
        }
        // 当前节点加上标记值
        // 注意：需要乘该子树所有叶子节点
        node.left.val += node.lazy * leftNum;
        node.right.val += node.lazy * rightNum;
        // 把标记下推给孩子节点
        node.left.lazy = node.lazy;
        node.right.lazy = node.lazy;
        // 取消当前节点标记
        node.lazy = 0;
    }

    public void update(Node node, int start, int end, int l, int r, int val) {
        // 找到满足要求的区间
        if (l <= start && end <= r) {
            // 区间节点加上更新值
            // 注意：需要✖️该子树所有叶子节点
            node.val += (end - start + 1) * val;
            // 添加懒惰标记
            node.lazy = val;
            return ;
        }
        int mid = (start + end) >> 1;
        // 下推标记
        pushDown(node, mid - start + 1, end - mid);
        // [start, mid] 和 [l, r] 可能有交集，遍历左孩子区间
        if (l <= mid) {
            update(node.left, start, mid, l, r, val);
        }
        // [mid + 1, end] 和 [l, r] 可能有交集，遍历右孩子区间
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, val);
        }
        // 向上更新
        pushUp(node);
    }
}
