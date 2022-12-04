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

    /**
     * LeetCode #33 搜索旋转排序数组（数组元素互不相同）
     */
    public int searchRotated(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
            }
            // 注意这个等号，为避免只有两个元素的旋转数组，目标值在后一位，如 nums = [3, 1], target = 1
            // 如果不加等号，则直接进入下一个分支令 right = mid - 1 错过答案
            if (nums[left] <= nums[mid]) {   // [left, mid) 部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    // target 在 [left, mid) 中，则在 [left, mid-1] 中继续搜索
                    right = mid - 1;
                } else {
                    // 否则在 (mid, right] 中继续搜索
                    left = mid + 1;
                }
            } else {                        // (mid, right] 部分有序
                if (target > nums[mid] && target <= nums[right]) {
                    // target 在 (mid, right] 中，则在 [mid+1, right] 中继续搜索
                    left = mid + 1;
                } else {
                    // 否则在 [left, mid) 中继续搜索
                    right = mid - 1;
                }
            }
        }
        return ans;
    }

}
