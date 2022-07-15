package tree;

public class TestTree {
    public static void main(String[] args) {
        var bt = new BinaryTree();
        int NULL = bt.getNullValue();
        int[] values = new int[] {1, 2, 3, 4, NULL, 5, 6, NULL, NULL, NULL, NULL, 7};
        var root = bt.createBinaryTree(values, 0);
        bt.printBinaryTree(root);
        LargestValueInEachRow sol = new LargestValueInEachRow();
        var maxValues = sol.largestValues(root);
        System.out.println(maxValues.toString());
    }
}
