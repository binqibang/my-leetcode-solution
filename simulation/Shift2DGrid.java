package simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 1260 (Easy)
 * @author binqibang
 * @date 2022/7/20
 */
public class Shift2DGrid {
    /**
     * 直接模拟，需要存储最后一列 <br>
     * Time: O(kmn), Space: O(m)
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int i = 0; i < k; i++) {
            shift(grid);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }

    public void shift(int[][] grid) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[] lastColumn = new int[m];
        for (int i = 0; i < m; i++) {
            lastColumn[i] = grid[i][n-1];
        }
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j > 0; j--) {
                grid[i][j] = grid[i][j-1];
            }
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = lastColumn[i-1];
        }
        grid[0][0] = lastColumn[m-1];
    }

    /**
     * 仔细观察后可以发现，化成一维数组后，实际上就是将数组向右移动 k 位 <br>
     * grid[i][j] -> [i * n + j]
     * k 次迁移后，idx -> (idx + k) % (m * n)
     * Time: O(mn); Space: O(1)
     */
    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ret.add(row);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = (i * n + j + k) % (m * n);
                ret.get(index / n).set(index % n, grid[i][j]);
            }
        }
        return ret;
    }

}
