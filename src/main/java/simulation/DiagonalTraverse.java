package simulation;

import java.util.Arrays;

/**
 * Question: LeetCode #498 (Medium)
 * Time: O(m * n); Space: O(1)
 * @author binqibang
 * @date 2022/6/13
 */
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[ m * n];
        int idx = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                // 左下方向，矩阵上半部分从(0, i)开始，下半部分从(i-n+1, n-1)开始
                // x-- y++
                int x = i < n ? 0 : i - n + 1;
                int y = i - x;
                while (x < m && y >= 0) {
                    res[idx] = mat[x][y];
                    idx++;
                    x++;
                    y--;
                }
            } else {
                // 右上方向，矩阵上半部分从(i, 0)开始，下半部分从(m-1, i-m+1)开始
                // x-- y++
                int x = i < m ? i : m - 1;
                int y = i - x;
                while (x >= 0 && y < n) {
                    res[idx] = mat[x][y];
                    idx++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test= new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        var res = findDiagonalOrder(test);
        System.out.println(Arrays.toString(res));
    }
}
