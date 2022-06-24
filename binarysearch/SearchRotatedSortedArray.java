package binarysearch;

/**
 * Search in rotated sorted array (Medium)<br>
 * QUESTION: There is an integer array nums sorted in non-decreasing order (distinct values).
 * Before being passed to your function, nums is rotated at an unknown pivot index
 * k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1],
 * ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example,
 * [0,1,2,4,5,6,7] might be rotated to [4,5,6,7,0,1,2].
 * Given the array nums after the rotation and an integer target, return index if
 * target is in nums, or -1 if it is not in nums.
 * @author    binqibang
 * @created   2021/04/07
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        if(nums.length == 0) {
            return -1;
        }

        if(nums.length == 1) {
            return nums[0] == target ? 0:-1;
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            // nums[left]~nums[mid] are partially ordered
            if(nums[left] <= nums[mid]) {
                // if target in [nums[left], nums[mid]]
                if(nums[left] <= target && nums[mid] > target){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // if target in [nums[mid], nums[right]]
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
