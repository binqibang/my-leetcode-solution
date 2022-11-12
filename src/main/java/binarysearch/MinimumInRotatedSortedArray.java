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
        int low = 0, high = nums.length - 1;
        int pivot;
        while (low < high){
            pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]){
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
