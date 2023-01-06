package sort;

import java.util.*;

/**
 * LeetCode #56 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/13
 */
public class MergeIntervals {
    /**
     * Time: O(nlogn); Space: O(n)
     * @param intervals intervals[i] = [start_i, end_i],
     * @return an array of the non-overlapping intervals
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1], n = merged.size();
            if (n == 0 || l > merged.get(n - 1)[1]) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(n - 1)[1] = Math.max(merged.get(n - 1)[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals  = new int[][] {{1,3},{8,10},{2,6},{15,18}};
        var res = merge(intervals);
        for (int[] arr : res) {
            System.out.print(Arrays.toString(arr) + " ");
        }
    }
}
