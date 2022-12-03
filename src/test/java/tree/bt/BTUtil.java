package tree.bt;

class BTUtil {
    private static final BinaryTree bt = new BinaryTree();
    public static final int NULL = Integer.MAX_VALUE;

    public static BTNode createBT(int[] values) {
        return bt.createBT(values);
    }

    public static void printBT(BTNode root) {
        bt.printBinaryTree(root);
    }
}