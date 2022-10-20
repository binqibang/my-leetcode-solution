package graph.grid;

/**
 * LeetCode #200 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/26
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfsNum(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfsNum(char[][] grid, int i, int j) {
        // cross the border
        if (isCrossBorder(grid, i, j)) {
            return;
        }
        // visit water or is visited
        if (grid[i][j] != '1') {
            return;
        }
        // mark as visited
        grid[i][j] = '2';
        // dfs
        dfsNum(grid, i - 1, j);
        dfsNum(grid, i + 1, j);
        dfsNum(grid, i, j - 1);
        dfsNum(grid, i, j + 1);
    }

    private boolean isCrossBorder(char[][] grid, int i, int j) {
        int rowLen = grid.length, colLen = grid[0].length;
        return i < 0 || i >= rowLen || j < 0 || j >= colLen;
    }
}
