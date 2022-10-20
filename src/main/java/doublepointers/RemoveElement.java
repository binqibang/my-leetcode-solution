package doublepointers;

import java.util.Scanner;

/**
 * QUESTION: Given a array 'nums' and a value 'val', remove the elements that equals val in-place and
 * return the new length after modifying. Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * @author   binqibang
 * @created  2021/04/19
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int slow, fast;
        if (nums.length == 0) {
            return 0;
        }
        slow = fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
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
        int value = input.nextInt();
        input.close();

        int newLength = removeElement(test,value);
        for (int i = 0; i < newLength; i++) {
            System.out.print(test[i] + " ");
        }
    }
}
