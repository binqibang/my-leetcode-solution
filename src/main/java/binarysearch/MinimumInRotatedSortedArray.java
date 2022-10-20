package binarysearch;
/**
 * Find Minimum in Rotated Sorted Array (Medium)<br>
 * QUESTION: Suppose an array of length n sorted in ascending order is rotated between 1 and n
 * times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times. [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * @author    binqibang
 * @created   2021/04/08
 */
public class MinimumInRotatedSortedArray {
    /** Traverse the array, when finding inverted sequence, which means finding
     *  the rotated point, namely minimum. If given array is ordered, then return
     *  first element.
     */
    public int findMin(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i+1]){
                return nums[i+1];
            }
        }
        return nums[0];
    }

    /** Binary search variant*/
    public int findMin_1(int[] nums){
        int low = 0;
        int high = nums.length - 1;
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
