package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Search2DMatrixTest {
    private Search2DMatrix s2d;
    private int[][] matrix;
    int target;

    @BeforeEach
    void setUp() {
        s2d = new Search2DMatrix();
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        target = 3;
    }

    @Test
    void searchMatrix() {
        boolean a1 = s2d.searchMatrix(matrix, target);
        boolean a2 = s2d.searchMatrix1(matrix, target);
        Assertions.assertEquals(a1, a2);
    }

    @Test
    void binarySearchFirstColumn() {
        System.out.println(s2d.binarySearchFirstColumn(matrix, 11));
    }
}