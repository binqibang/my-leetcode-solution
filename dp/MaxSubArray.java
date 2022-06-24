package dp;

import java.util.Scanner;

/**
 * QUESTION: Given an integer array nums, find the contiguous subarray (containing at least one number)
 *           which has the largest sum and return its sum.
 * @author   binqibang
 * @created  2021/7/17
 */

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int x:nums) {
            pre = Math.max(x, pre + x);
            res = Math.max(pre, res);
        }
        return res;
    }

    /** TestCalendar */
    public static void main(String[] args) {
        // input a non-length-limited array
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] array = str.split(" ");
        int[] test = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            test[i] = Integer.parseInt(array[i]);
        }

        System.out.println(maxSubArray(test));
    }
}


