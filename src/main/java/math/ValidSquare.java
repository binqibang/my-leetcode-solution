package math;

import java.util.Arrays;

/**
 * LeetCode #593 (Medium)
 * @author binqibang
 * @date 2022/7/29
 */
public class ValidSquare {
    /**
     * 本题思路很清晰，先判断四个角是不是都是直角，再判断邻边是否相等。<br>
     * 坑在于如果出现有重合的点，上述判断很可能出错，所以先排除此情况。<br>
     * Time: O(1); Space: O(1)
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 任意两点重合，不能组成正方形
        if (Arrays.equals(p1, p2) || Arrays.equals(p1, p3) || Arrays.equals(p1, p4)
                || Arrays.equals(p2, p3) || Arrays.equals(p2, p4) || Arrays.equals(p3, p4)) {
            return false;
        }
        // 判断四个角是否都是直角
        int normalCount = isNormal(p1, p2, p3) + isNormal(p2, p3, p4) +
                isNormal(p1, p3, p4) + isNormal(p1, p2, p4);
        if (normalCount < 4) {
            return false;
        }
        // 任选三个点判断邻边是否相等
        return isAdjEqual(p1, p2, p3);
    }

    public int isNormal(int[] p1, int[] p2, int[] p3) {
        int[] v1 = new int[]{p2[0] - p1[0], p2[1] - p1[1]};
        int[] v2 = new int[]{p3[0] - p1[0], p3[1] - p1[1]};
        int[] v3 = new int[]{p3[0] - p2[0], p3[1] - p2[1]};
        if (v1[0] * v2[0] + v1[1] * v2[1] == 0) {
            return 1;
        } else if (v1[0] * v3[0] + v1[1] * v3[1] == 0) {
            return 1;
        } else if (v2[0] * v3[0] + v2[1] * v3[1] == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean isAdjEqual(int[] p1, int[] p2, int[] p3){
        int l1 = (p2[0]-p1[0]) * (p2[0]-p1[0]) + (p2[1]-p1[1]) * (p2[1]-p1[1]);
        int l2 = (p3[0]-p1[0]) * (p3[0]-p1[0]) + (p3[1]-p1[1]) * (p3[1]-p1[1]);
        int l3 = (p3[0]-p2[0]) * (p3[0]-p2[0]) + (p3[1]-p2[1]) * (p3[1]-p2[1]);
        // 找到斜边
        int max = Math.max(l1, Math.max(l2, l3));
        if (l1 == max) {
            return l2 == l3;
        } else if (l2 == max) {
            return l1 == l3;
        } else {
            return l1 == l2;
        }
    }
}
