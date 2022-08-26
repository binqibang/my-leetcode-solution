package tree;

import tree.bt.*;

public class TestTree {
    public static void main(String[] args) {
        // Test create binary tree
        System.out.println("Test create binary tree");
        var bt = new BinaryTree();
        int NULL = bt.getNullValue();
        int[] values = new int[] {1, 2, 3, 4, NULL, 5, 6, NULL, NULL, NULL, NULL, 7};
        var root = bt.createBinaryTree(values, 0);
        bt.printBinaryTree(root);
        System.out.println("-".repeat(50));

        // Test LargestValueInEachRow
        System.out.println("Test LargestValueInEachRow");
        LargestValueInEachRow sol = new LargestValueInEachRow();
        var maxValues = sol.largestValues(root);
        System.out.println(maxValues.toString());
        System.out.println("-".repeat(50));

        // Test BinaryTreePruning
        System.out.println("Test BinaryTreePruning");
        int[] values1 = new int[] {1,NULL,0,NULL, NULL, 0,1};
        var test = bt.createBinaryTree(values1, 0);
        bt.printBinaryTree(test);
        BinaryTreePruning sol1 = new BinaryTreePruning();
        var res = sol1.pruneTree(test);
        bt.printBinaryTree(res);
        System.out.println("-".repeat(50));

        // Test CBTInserter
        System.out.println("Test CBTInserter");
        int[] values2 = new int[] {1, 2, 3, 4, 5, 6};
        var test1 = bt.createBinaryTree(values2, 0);
        CBTInserter inserter = new CBTInserter(test1);
        for (int i = 7; i < 15; i++) {
            inserter.insert(i);
        }
        bt.printBinaryTree(inserter.getRoot());
        System.out.println("-".repeat(50));

        // Test MaxLevelSum
        System.out.println("Test MaxLevelSum");
        int[] values3 = new int[] {1, 7, 0, 7, -8, NULL, NULL};
        var test2 = bt.createBinaryTree(values3, 0);
        MaxLevelSum sol2 = new MaxLevelSum();
        System.out.println(sol2.maxLevelSum(test2));
        System.out.println("-".repeat(50));

        // Test AddOneRow
        System.out.println("Test AddOneRow");
        AddOneRow sol3 = new AddOneRow();
        bt.printBinaryTree(test2);
        bt.printBinaryTree(sol3.addOneRow(test2, 2, 2));
        System.out.println("-".repeat(50));

        // Test DeepestLeavesSum
        System.out.println("Test DeepestLeavesSum");
        int[] values4 = new int[] {1,2,3,4,5,NULL,6,7,NULL,NULL,NULL,NULL,NULL,NULL,8};
        var test3 = bt.createBinaryTree(values4, 0);
        bt.printBinaryTree(test3);
        DeepestLeavesSum sol4 = new DeepestLeavesSum();
        System.out.println(", sum is " + sol4.deepestLeavesSum(test3));
        System.out.println("-".repeat(50));

        // Test PrintTree
        System.out.println("Test PrintTree");
        PrintTree sol5 = new PrintTree();
        var matrix = sol5.printTree(test3);
        for (var row : matrix) {
            for (var node : row) {
                if (node.equals("")) {
                    System.out.print("  ");
                } else {
                    System.out.print(node + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-".repeat(50));

        // Test LowestCommonAncestor
        System.out.println("Test LowestCommonAncestor");
        LowestCommonAncestor sol6 = new LowestCommonAncestor();
        BTNode p = test3.getLeft().getRight();
        BTNode q = test3.getLeft().getLeft().getLeft();
        System.out.println(sol6.lowestCommonAncestor1(test3, p, q).getVal());

        LowestCommonAncestorII sol7 = new LowestCommonAncestorII();
        System.out.println(sol7.lowestCommonAncestor(test3, p, new BTNode(0)));
    }
}
