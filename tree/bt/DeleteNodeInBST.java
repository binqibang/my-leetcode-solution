package tree.bt;

/**
 * Question: LeetCode #450 (Medium)
 * @author binqibang
 * @date 2022/6/2
 */
public class DeleteNodeInBST {
    public static BTNode deleteNode(BTNode root, int key) {
        // empty tree.bst
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
            BTNode successor = root.left;
            while (successor.right != null) {
                successor = successor.right;
            }
            successor.right = root.right;
            return root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(5);
        BTNode node1 = new BTNode(3);
        BTNode node2 = new BTNode(6);
        BTNode node3 = new BTNode(2);
        BTNode node4 = new BTNode(4);
        BTNode node5 = new BTNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        BTNode newRoot = deleteNode(root, 3);
    }
}
