package tree.bt;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private final int NULL_VALUE = Integer.MAX_VALUE;

    public int getNullValue() {
        return NULL_VALUE;
    }

    public BTNode createBT(int[] values) {
        return createBinaryTree(values, 0);
    }

    public BTNode createBinaryTree(int[] values, int idx) {
        if (values[idx] == NULL_VALUE) {
            return null;
        }
        var root = new BTNode(values[idx]);
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

    public void preorderTraversal(BTNode root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void postorderTraversal(BTNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.printf("%d ", root.val);
    }

    public void inorderTraversal(BTNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.printf("%d ", root.val);
        inorderTraversal(root.right);
    }

    public void inorderTraversal1(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        BTNode iter = root;
        while (!stack.isEmpty() || iter != null) {
            while (iter != null) {
                stack.push(iter);
                iter = iter.left;
            }
            iter = stack.pop();
            System.out.printf("%d ", iter.val);
            iter = iter.right;
        }
    }

    public void levelTraversal(BTNode root) {
        Queue<BTNode> queue = new ArrayDeque<>();
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

    public void printBinaryTree(BTNode root) {
        print("", root, false);
    }

    private void print(String prefix, BTNode root, boolean isLeft) {
        if (root != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + root.val);
            print(prefix + (isLeft ? "|   " : "    "), root.left, true);
            print(prefix + (isLeft ? "|   " : "    "), root.right, false);
        }
    }

    public int minDepth(BTNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    public int maxDepth(BTNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}