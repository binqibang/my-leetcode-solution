package binarysearch;

/**
 * LeetCode #34 (Medium); CodeTop MS
 * @author binqibang
 * @date 2021/10/10
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int startIdx = binarySearch(nums, target, true);
        int endIdx = binarySearch(nums, target, false) - 1;
        if (startIdx <= endIdx && endIdx < nums.length && nums[startIdx] == target
                && nums[endIdx] == target) {
            return new int[]{startIdx, endIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean equal) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (equal && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
