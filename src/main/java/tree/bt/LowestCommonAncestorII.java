package tree.bt;

/**
 * LeetCode #1644 (Medium)
 * @author binqibang
 * @date 2022/8/25
 */
public class LowestCommonAncestorII {
    private int count = 0;

    public BTNode lowestCommonAncestor(BTNode root, BTNode p, BTNode q) {
        BTNode ans = lca(root, p, q);
        return count == 2? ans : null;
    }

    public BTNode lca(BTNode root, BTNode p, BTNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            count++;
            return root;
        }
        BTNode left = lca(root.left, p, q);
        BTNode right = lca(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

}
