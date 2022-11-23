package tree.bt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static tree.bt.BTUtil.NULL;

class BalancedBinaryTreeTest {
    private BalancedBinaryTree bbt;

    @BeforeEach
    void setUp() {
        bbt = new BalancedBinaryTree();
    }

    @Test
    void isBalanced() {
        int[] values = new int[] {1,2,2,3,NULL,NULL,4,4,3};
        var root = BTUtil.createBT(values);
        BTUtil.printBT(root);
        System.out.println(bbt.isBalanced(root));
    }
}