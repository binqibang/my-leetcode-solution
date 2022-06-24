package doublepointers;

import java.util.Scanner;

/**
 * QUESTION: Given a sorted array nums, remove the duplicates in-place such that each element appears
 * only once and returns the new length. Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * @author   binqibang
 * @created  2021/04/18
 */
public class RemoveDuplicatesOfSortedArray {
    public static int removeDuplicates (int[] nums) {
        int slow,fast;
        if (nums.length == 0){
            return 0;
        }
        slow = fast = 1;
        while (fast < nums.length){
            if (nums[fast] != nums[fast - 1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] strArray = str.split(" ");
        int[] test = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            test[i] = Integer.parseInt(strArray[i]);
        }

        int newLength = removeDuplicates(test);
        System.out.println(newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.printf("%d ",test[i]);
        }
    }
}
