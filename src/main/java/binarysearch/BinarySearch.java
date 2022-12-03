package binarysearch;

/**
 * 二分查找总结
 * @author binqibang
 * @date 2022/11/29
 */
public class BinarySearch {

    /**
     * LeetCode #35 搜索插入位置
     * @param nums a sorted array of distinct integers and a target value.
     * @return the index if the target is found. If not, return the index where it would be.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // right 选择 length-1 时结束条件选择 left <= right
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 因为结束条件 left <= right，如果 left = mid，会陷入死循环
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * LeetCode #34 在含有多个目标值的数组中搜索左右边界
     * @param isLeftRange true if search left range, false if search right range.
     */
    public int searchRange(int[] nums, int target, boolean isLeftRange) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (isLeftRange) {
                    // 这里能判断出 mid 可能是左边界，但对于 mid - 1 无法判断的
                    right = mid - 1;
                } else {
                    // 这里能判断出 mid 可能是右边界，但对于 mid + 1 无法判断的
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}
