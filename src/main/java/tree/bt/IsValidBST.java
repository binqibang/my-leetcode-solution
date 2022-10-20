package tree.bt;

import java.util.Stack;

/**
 * LeetCode #98 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/11
 */
public class IsValidBST {
    // node.val: [MIN_INT, MAX_INT]
    long pre = Long.MIN_VALUE;

    /**
     * Inorder traversal judge if strictly increasing. <br>
     * Time: O(n); Space: O(n)
     * @param root root node
     * @return true if it is a BST
     */
    public boolean isValidBST(BTNode root) {
        // visit null node, temporally return true
        if (root == null) {
            return true;
        }
        // if left subtree is not a BST
        if (!isValidBST(root.left)) {
            return false;
        }
        // if not strictly increasing
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // if right subtree is not a BST, return false;
        // else return true
        return isValidBST(root.right);
    }

    /**
     * Non-recursive inorder traversal <br>
     * Time: O(n); Space: O(n)
     */
    public boolean isValidBST1(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        BTNode node = root;
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(root);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= pre) {
                return false;
            }
            pre = node.val;
            root = node.right;
        }
        return true;
    }

    /**
     * Preorder traversal.
     * Time: O(n); Space: O(n)
     */
    public boolean isValidBST2(BTNode root) {
        return preorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean preorder(BTNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return preorder(root.left, lower, root.val) &&
                preorder(root.right, root.val, upper);
    }

}
