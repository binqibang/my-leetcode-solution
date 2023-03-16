package simulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SpiralMatrixTest {

    private SpiralMatrix sm;

    @BeforeEach
    void setUp() {
        sm = new SpiralMatrix();
    }

    @Test
    void spiralOrder() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 10},
                {4, 5, 6, 11},
                {7, 8, 9, 12}
        };
        System.out.println(sm.spiralOrder(matrix));
    }

    @Test
    void generateMatrix() {
        int n = 3;
        var matrix = sm.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}