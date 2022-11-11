package dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinPathSumTest {
    private MinPathSum mps;

    @BeforeEach
    void setUp() {
        mps = new MinPathSum();
    }

    @Test
    void minPathSum() {
        int[][] grid = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(mps.minPathSum(grid));
    }
}