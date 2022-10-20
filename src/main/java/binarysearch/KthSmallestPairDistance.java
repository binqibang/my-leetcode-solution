package binarysearch;

import java.util.*;

/**
 * LeetCode #719 (Hard)
 * @author binqibang
 * @date 2022/6/15
 */
public class KthSmallestPairDistance {
    /**
     * 暴力解法，遍历+排序
     * Time: O(n^2) Space: O(n^2)
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair1(int[] nums, int k) {
        int n = nums.length;
        int[] distances = new int[n * (n - 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                distances[idx] = Math.abs(nums[i] - nums[j]);
                idx++;
            }
        }
        Arrays.sort(distances);
        return distances[k - 1];
    }

    /**
     * 二分查找
     * Time: O(n×(logn+logD)); Space: O(logn)
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair2(int[] nums, int k) {
        int n = nums.length;
        // 将数组进行排序，则距离取值范围：0 ~ (nums[n - 1] - nums[0])
        // 如此可进行二分查找直到找到 k 对距离
        Arrays.sort(nums);
        int low = 0, high = nums[n - 1] - nums[0];
        while (low <= high) {
            int mid = (high + low) / 2;
            // 双指针法查找有多少数对距离小于 mid
            int count = 0, i = 0;
            // 遍历右端点，若距离超过mid，则右移左端点
            // 每次遍历符合条件的数对多 j-i
            for (int j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                count += j - i;
            }
            if (count >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        var nums = new int[] {1,6,1,2,3,3};
        var k = 10;
        System.out.println(smallestDistancePair1(nums, k));
        System.out.println(smallestDistancePair2(nums, k));
    }
}
