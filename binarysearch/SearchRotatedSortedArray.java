package binarysearch;

/**
 * LeetCode #33 (Medium); CodeTop MS
 * @author binqibang
 * @date 2021/04/07
 */
public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // When the array is split in the `mid`, half of it is always in order,
            // then we binary search in the ordered part.
            if (nums[left] <= nums[mid]) { // nums[left] ~ nums[mid] are partially ordered
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]){ // nums[mid] ~ nums[right] are partially ordered
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
