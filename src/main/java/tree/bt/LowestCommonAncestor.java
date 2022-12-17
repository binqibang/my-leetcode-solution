package tree.bt;

/**
 * LeetCode #236 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/8/25
 */
public class LowestCommonAncestor {
    public BTNode lowestCommonAncestor(BTNode root, BTNode p, BTNode q) {
        if (root == null) {
            return null;
        }
        // p,q 为根节点，则公共祖先只能为根节点
        if (p == root || q == root) {
            return root;
        }
        BTNode left = lowestCommonAncestor(root.left, p, q);
        BTNode right = lowestCommonAncestor(root.right, p, q);
        // 左子树中未找到
        if (left == null) {
            return right;
        }
        // 右子树中未找到
        if (right == null) {
            return left;
        }
        return root;
    }

    public BTNode lowestCommonAncestor1(BTNode root, BTNode p, BTNode q) {
        if (root == null) {
            return null;
        }
        // p,q 为根节点，则公共祖先只能为根节点
        if (p == root || q == root) {
            return root;
        }
        // p,q 在左子树，则公共祖先在左子树查找
        if (find(root.left, p) && find(root.left, q)) {
            return lowestCommonAncestor1(root.left, p, q);
        }
        // p,q 在右子树，则公共祖先在右子树查找
        if (find(root.right, p) && find(root.right, q)) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        // p,q 分属两侧，则公共祖先为根节点
        return root;
    }

    private boolean find(BTNode root, BTNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return find(root.left, p) || find(root.right, p);
    }
}
