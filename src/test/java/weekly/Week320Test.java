package weekly;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.bt.BTNode;
import tree.bt.BinaryTree;

import java.util.List;

class Week320Test {
    private static final int NULL = Integer.MAX_VALUE;
    private Week320 week320;
    private BinaryTree bt;

    @BeforeEach
    void setUp() {
        week320 = new Week320();
        bt = new BinaryTree();
    }

    @Test
    void unequalTriplets() {
        int[] nums = new int[] {4,4,2,4,3};
        Assertions.assertEquals(3, week320.unequalTriplets(nums));
    }

    @Test
    void closestNodes() {
        int[] values = new int[]{6,2,13,1,4,9,15, NULL, NULL, NULL, NULL, NULL, NULL,14};
        List<Integer> queries = List.of(2, 5, 16);
        BTNode root = bt.createBT(values);
        bt.printBinaryTree(root);
        System.out.println(week320.closestNodes(root, queries));
    }

    @Test
    void minimumFuelCost() {
        int[][] roads = new int[][] {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        int seats = 3;
        Assertions.assertEquals(6, week320.minimumFuelCost(roads, seats));
    }
}