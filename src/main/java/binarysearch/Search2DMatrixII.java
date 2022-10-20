package binarysearch;

/**
 * LeetCode #240 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/19
 */
public class Search2DMatrixII {
    /**
     * Solution1: Binary search in each row, Time: O(m * logn); Space: O(1)
     * @param matrix each row are sorted in ascending from left to right, while
     *               each column are sorted in ascending from top to bottom.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int idx = binarySearch(row, target);
            if (idx >= 0) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return mid;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Solution2: 2D binary search, Time: O(m + n); Space: O(1)
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // start search from right-top of matrix [0, n-1]
        int x = 0, y = n - 1;
        while (x < m && y >= 0) { // (0 <=) x < m, 0 <= y (< n)
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) { // x-th row are all less than target
                x++;
            } else {    // y-th column are all bigger than target
                y--;
            }
        }
        return false;
    }
}
