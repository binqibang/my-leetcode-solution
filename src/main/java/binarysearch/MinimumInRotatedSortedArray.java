package binarysearch;
/**
 * LeetCode #153 (Medium); CodeTop MS
 * @author binqibang
 * @date 2021/04/08
 */
public class MinimumInRotatedSortedArray {
    /**
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     * @param nums an array of length n with unique elements sorted in ascending order
     *             is rotated, like [4,5,6,7,0,1,2] if it was rotated 4 times.
     * @return the minimum element of this array.
     */
    public int findMin(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]){
                return nums[i+1];
            }
        }
        return nums[0];
    }

    /**
     * @TimeComplexity O(logn)
     * @SpaceComplexity O(1)
     */
    public int findMin1(int[] nums){
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right){
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {  // [left, mid) 递增，向右继续查找
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {                        // (mid, right] 递增，向左继续查找
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }
}
