package graph.grid;

/**
 * LeetCode #695 (Medium)
 * @author binqibang
 * @date 2022/9/26
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int curArea = dfsArea(grid, i, j);
                maxArea = Math.max(curArea, maxArea);
            }
        }
        return maxArea;
    }

    private int dfsArea(int[][] grid, int i, int j) {
        if (isCrossBorder(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfsArea(grid, i - 1, j) + dfsArea(grid, i + 1, j) +
                dfsArea(grid, i, j - 1) + dfsArea(grid, i, j + 1);
    }

    private boolean isCrossBorder(int[][] grid, int i, int j) {
        int rowLen = grid.length, colLen = grid[0].length;
        return i < 0 || i >= rowLen || j < 0 || j >= colLen;
    }
}
