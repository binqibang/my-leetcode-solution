package simulation;

/**
 * LeetCode #48 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/14
 */
public class RotateImage {
    /**
     * 观察可知 matrix[i][j] -> matrix_new[j][n-1-i] <br>
     * 使用辅助数组，空间复杂度 O(n^2)
     * @param matrix (n, n) 2D matrix representing an image
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] back = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                back[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = back[i][j];
            }
        }
    }

    /**
     * 连续原地旋转四次即可实现原地旋转，空间复杂度 O(1)
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}

