package bt;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {

    private final int NULL_VALUE = Integer.MAX_VALUE;

    public int getNullValue() {
        return NULL_VALUE;
    }

    public TreeNode createBinaryTree(int[] values, int idx) {
        if (values[idx] == NULL_VALUE) {
            return null;
        }
        var root = new TreeNode(values[idx]);
        int leftIdx = 2 * idx + 1;
        int rightIdx = 2 * idx + 2;
        if (leftIdx < values.length) {
            root.left = createBinaryTree(values, leftIdx);
        } else {
            root.left = null;
        }
        if (rightIdx < values.length) {
            root.right = createBinaryTree(values, rightIdx);
        } else {
            root.right = null;
        }
        return root;
    }

    public void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.printf("%d ", root.val);
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.printf("%d ", root.val);
        inorderTraversal(root.right);
    }

    public void levelTraversal(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                var curr = queue.poll();
                System.out.printf("%d ", curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            System.out.println();
        }
    }

    public void printBinaryTree(TreeNode root) {
        print("", root, false);
    }

    private void print(String prefix, TreeNode root, boolean isLeft) {
        if (root != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + root.val);
            print(prefix + (isLeft ? "|   " : "    "), root.left, true);
            print(prefix + (isLeft ? "|   " : "    "), root.right, false);
        }
    }
}