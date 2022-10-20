package tree.bt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    public BinaryTree bt;
    public BTNode root;
    private static final int NULL = Integer.MAX_VALUE;

    @BeforeEach
    void createBinaryTree() {
        bt = new BinaryTree();
        int[] values = new int[] {4, 2, 5, 1, 3, NULL, 6};
        root = bt.createBinaryTree(values, 0);
        bt.printBinaryTree(root);
    }

    @Test
    void inorderTraversal() {
        bt.inorderTraversal(root);
        System.out.println();
        bt.inorderTraversal1(root);
    }


}