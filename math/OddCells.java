package math;

import java.util.Random;

/**
 * LeetCode #1252
 * @author binqibang
 * @date 2022/7/12
 */
public class OddCells {
    /**
     * 直接模拟，建立 m*n 矩阵<br>
     * Time: O(q×(m+n)+m×n)); Space: O(mn)
     */
    public static int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int ans = 0;
        for (var index : indices) {
            for (int j = 0; j < n; j++) {
                matrix[index[0]][j]++;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][index[1]]++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * Time: O(q+m+n); Space: O(m+n)
     */
    public static int oddCells1(int m, int n, int[][] indices) {
        // 记录+1次数
        int[] row = new int[m];
        int[] column = new int[n];
        for (var index : indices) {
            row[index[0]]++;
            column[index[1]]++;
        }
        // 统计行被+1次数
        int oddX = 0;
        // 统计列+1次数
        int oddY = 0;
        for (int i = 0; i < m; i++) {
            if (row[i] % 2 == 0) {
                oddX++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (column[i] % 2 == 0) {
                oddY++;
            }
        }
        // 奇数 = 奇数 * 偶数
        return oddX * (n - oddY) + (m - oddX) * oddY;
    }

    public static void main(String[] args) {
        int m = 50, n = 50;
        Random random = new Random();
        int[][] indices = new int[100][];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = new int[]{random.nextInt(50), random.nextInt(50)};
        }
        long startTime = System.nanoTime();
        System.out.println(oddCells(m, n, indices));
        long endTime = System.nanoTime();
        System.out.printf("oddCells has spent %f ms.\n", (endTime-startTime)/1e6);

        startTime = System.nanoTime();
        System.out.println(oddCells1(m, n, indices));
        endTime = System.nanoTime();
        System.out.printf("oddCells1 has spent %f ms.\n", (endTime-startTime)/1e6);
    }
}
