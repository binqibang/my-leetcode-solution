package simulation;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * LeetCode #54
     * Given an (m, n) matrix, return all elements of the matrix in spiral order.
     * @param matrix matrix (m, n)
     * @return all elements of the matrix in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) {
            return ans;
        }
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int count = m * n;
        while (count >= 1) {
            for (int i = left; i <= right && count >= 1; i++) {
                ans.add(matrix[top][i]);
                count--;
            }
            top++;
            for (int i = top; i <= bottom && count >= 1; i++) {
                ans.add(matrix[i][right]);
                count--;
            }
            right--;
            for (int i = right; i >= left && count >= 1; i--) {
                ans.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            for (int i = bottom; i >= top && count >= 1; i--) {
                ans.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return ans;
    }

    /**
     * LeetCode #59
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     * @param n a positive intege
     * @return an (n, n) matrix filled with elements from 1 to n^2 in spiral order
     */
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int count = 1, numElems = n * n;
        int[][] matrix = new int[n][n];
        while (count <= numElems) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left++;
        }
        return matrix;
    }
}
