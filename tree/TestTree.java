package tree;

import tree.bt.BinaryTree;
import tree.bt.BinaryTreePruning;
import tree.bt.LargestValueInEachRow;

public class TestTree {
    public static void main(String[] args) {
        // Test create binary tree
        var bt = new BinaryTree();
        int NULL = bt.getNullValue();
        int[] values = new int[] {1, 2, 3, 4, NULL, 5, 6, NULL, NULL, NULL, NULL, 7};
        var root = bt.createBinaryTree(values, 0);
        bt.printBinaryTree(root);

        // Test LargestValueInEachRow
        LargestValueInEachRow sol = new LargestValueInEachRow();
        var maxValues = sol.largestValues(root);
        System.out.println(maxValues.toString());
        System.out.println();

        // Test BinaryTreePruning
        int[] values1 = new int[] {1,NULL,0,NULL, NULL, 0,1};
        var test = bt.createBinaryTree(values1, 0);
        bt.printBinaryTree(test);
        BinaryTreePruning sol1 = new BinaryTreePruning();
        var res = sol1.pruneTree(test);
        bt.printBinaryTree(res);
    }
}
