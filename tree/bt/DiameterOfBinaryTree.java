package tree.bt;

/**
 * LeetCode #543 (Easy); CodeTop MS
 * @author binqibang
 * @date 2021/10/6
 */
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(BTNode root) {
        depth(root);
        return diameter;
    }

    private int depth(BTNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);    // depth of left subtree
        int right = depth(root.right);  // depth of right subtree
        // pathLen = depth(left) + depth(right)
        diameter = Math.max(left + right, diameter);
        // depth of current root
        return Math.max(left, right) + 1;
    }
}
