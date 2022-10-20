package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #1200 (Easy)
 * @author binqibang
 * @date 2022/7/4
 */
public class MinAbsDiff {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        // 只需判断相邻元素的距离，因为相隔更远的元素距离必然更大
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i+1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
                // 清除之前结果
                ans.clear();
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                ans.add(pair);
            } else if (diff == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                ans.add(pair);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[] {3,8,-10,23,19,-4,-14,27};
        var ans = minimumAbsDifference(test);
        System.out.println(ans);
    }
}
