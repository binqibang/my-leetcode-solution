package tree.bt;

import org.junit.jupiter.api.Test;

import static tree.bt.BTUtil.NULL;

class IsCompleteBinaryTreeTest {

    @Test
    void isCompleteBinaryTree() {
        IsCompleteBinaryTree cbt = new IsCompleteBinaryTree();
        int[] vals1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] vals2 = new int[] {1, 2, 3, 4, 5, NULL, NULL};
        BTNode root1 = BTUtil.createBT(vals1);
        BTNode root2 = BTUtil.createBT(vals2);
        cbt.isCompleteBinaryTree(root1);
        cbt.isCompleteBinaryTree(root2);
    }
}