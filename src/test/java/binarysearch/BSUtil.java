package binarysearch;

public class BSUtil {

    public static int[] createRotatedSortedArray(int n, int times) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        while (times != 0) {
            times--;
            int tmp = nums[n-1];
            for (int i = n-1; i > 0; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = tmp;
        }
        return nums;
    }
}
