package dp;

import java.util.Stack;

/**
 * LeetCode #64 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/11
 */
public class MinPathSum {
    /**
     * 二维动态规划
     * @TimeComplexity O(mn)
     * @SpaceComplexity O(1)
     * @param grid m x n grid filled with non-negative numbers
     * @return a path from top left to bottom right, which minimizes
     *         the sum of all numbers along its path.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 记录每步选择
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) { // 左上角初始值
                    continue;
                } else if (i == 0) {    // 上边界，只能从左来
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                    path[i][j] = 1;
                } else if (j == 0) {    // 左边界，只能从上来
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                    // path[i][j] = 0;
                } else {                // 其他位置，上左均可，选最小值
                    grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
                    // 1 表示从左来，0 表示从上来
                    path[i][j] = grid[i][j-1] < grid[i-1][j] ? 1 : 0;
                }
            }
        }
        // 逆推，生成结果路径
        int x = m - 1, y = n - 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {x, y});
        while (x + y != 0) {
            if (path[x][y] == 1) {
                y--;
            } else {
                x--;
            }
            stack.push(new int[]{x, y});
        }
        while (!stack.isEmpty()) {
            int[] point = stack.pop();
            System.out.print("(" + point[0] + ", " + point[1] + ")");
            if (stack.size() > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

        return grid[m-1][n-1];
    }
}
