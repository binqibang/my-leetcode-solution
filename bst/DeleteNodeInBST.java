package bst;

/**
 * Question: LeetCode #450 (Medium)
 * @author binqibang
 * @date 2022/6/2
 */
public class DeleteNodeInBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        // empty bst
        if (root == null) {
            return null;
        }

        // key node is in the left subtree
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        // key node is in the right subtree
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        // find the key node
        if (root.val == key) {
            // if leaf node, just delete it
            if (root.left == null && root.right == null) {
                return null;
            }
            // left subtree is empty, return its right subtree as new subtree
            if (root.left == null) {
                return root.right;
            }
            // right subtree is empty, return its left subtree as new subtree
            if (root.right == null) {
                return root.left;
            }
            // if both left and right subtree is not empty, then find the max node of its
            // left subtree to replace
            TreeNode successor = root.left;
            while (successor.right != null) {
                successor = successor.right;
            }
            successor.right = root.right;
            return root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        TreeNode newRoot = deleteNode(root, 3);
    }
}
