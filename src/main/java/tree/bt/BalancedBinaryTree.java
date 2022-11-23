package tree.bt;

/**
 * LeetCode #110 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/11/23
 */
public class BalancedBinaryTree {
    private boolean isBalanced;

    public boolean isBalanced(BTNode root) {
        if (root == null) {
            return true;
        }
        isBalanced = true;
        height(root);
        return isBalanced;
    }

    /**
     * 凡涉及到两边子树高度的递归问题，都可以下边的递归体
     */
    private int height(BTNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }
        // 注意这里返回的是整体子树高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
