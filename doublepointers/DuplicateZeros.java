package doublepointers;

import java.util.Arrays;

/**
 * LeetCode #1089 (Easy)
 * @author binqibang
 * @date 2022/6/17
 */
public class DuplicateZeros {
    /**
     * 暴力解法，碰到`0`后从后到前修改<br>
     * Time: O(n^2); Space: O(1)
     * @param arr
     */
    public static void duplicateZeros1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    /**
     * 观察发现元素右移位数正是其左边`0`的个数<br>
     * Time: O(n); Space: O(1)
     * @param arr
     */
    public static void duplicateZeros2(int[] arr) {
        int n = arr.length;
        // 统计`0`的个数
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            // 左边`0`个数减1
            if (arr[i] == 0) {
                count--;
            }
            // 右移后在数组范围内
            if (i + count < n) {
                // 右移`count`位
                arr[i + count] = arr[i];
                // arr[i]为`0`，还需在之后补`0`
                if (arr[i] == 0 && (i + count + 1) < n) {
                    arr[i + count + 1] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] test = new int[] {1,0,2,3,0,4,5,0};
        int[] test1 = new int[] {0,1,1,7,6,0,0,2};
        duplicateZeros1(test);
        duplicateZeros2(test1);
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(test1));
    }
}
