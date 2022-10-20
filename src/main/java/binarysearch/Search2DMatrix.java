package binarysearch;

/**
 * LeetCode #74 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/19
 */
public class Search2DMatrix {
    /**
     * Solution1: Treat a matrix as an ascending array, then binary search.
     * Coordinate: [i, j](2D) -> i * n + j(1D), => x(1D) -> [x / n, x % n](2D)
     * Time: O(log(mn)); Space: O(1)
     * @param matrix  m x n integer matrix
     * @param target search value
     * @return true if matrix has the target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cur = matrix[mid / n][mid % n];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        // Find last one which not bigger than target
        int rowIdx = binarySearchFirstColumn(matrix, target);
        if (rowIdx < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIdx], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
