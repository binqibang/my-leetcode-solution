package sort;

import java.util.Arrays;

/**
 * Question: LeetCode #1051 (Easy)
 * @author binqibang
 * @date 2022/6/13
 */
public class HeightChecker {
    /**
     * 直接排序<br>
     * Time : O(nlogn)
     * Space: O(n)
     * @param heights
     * @return number of incorrect position
     */
    public static int heightChecker1(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]){
                num += 1;
            }
        }
        return num;
    }

    /**
     * 桶排序应用，适用于数组中元素的值在一定区间内<br>
     * Time: O(n + m)
     * Space: O(m)
     * @param heights
     * @return number of incorrect position
     */
    public static int heightChecker2(int[] heights) {
        int max = Arrays.stream(heights).max().getAsInt();
        int[] bucket = new int[max + 1];
        for (int h : heights) {
            bucket[h] ++;
        }
        int idx = 0, num = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                if (heights[idx] != i) {
                    num++;
                }
                idx++;
            }
        }
        return num;
    }



    public static void main(String[] args) {
        int[] test = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker1(test));
        System.out.println(heightChecker2(test));
    }
}
