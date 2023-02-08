package sort;

import java.util.Arrays;

/**
 * LeetCode #581 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/8
 */
public class ShortestUnsortedSubarray {

    /**
     * 方法一：排序
     * 将原数组排序与原数组进行比较，取最长的相同的前缀和最长的相同的后缀。
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(n)
     */
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int begin = 0;
        while (nums[begin] == sorted[begin]) {
            begin++;
        }
        int end = nums.length - 1;
        while (nums[end] == sorted[end]) {
            end--;
        }
        return end - begin + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：一次遍历
     * 假设把这个数组分成三段，`左段`和`右段`是标准的升序数组，`中段`数组虽是无序的，
     * 但满足最小值大于`左段`的最大值，最大值小于`右段`的最小值，本题可以转化为寻找`中段`左右边界。
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        // 定义`中段`左右边界为`begin`和`end`
        int begin = 0, end = -1;
        // 从左到右维护一个最大值`max`，从右到左维护一个最小值`min`
        int min = nums[n-1], max = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[n-i-1] > min) {
                begin = n - i - 1;
            } else {
                min = nums[n-i-1];
            }
        }
        return end - begin + 1;
    }



}
