package sort;

public class MaxProduct {
    public static int maxProduct(int[] nums) {
        // a为最大值，b为次大值
        int a = nums[0], b = nums[1];
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (a < nums[i]) {
                b = a;
                a = nums[i];
            } else if (b < nums[i]) {
                b = nums[i];
            }
        }

        return (a - 1) * (b - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,1,8,1,5,4,5,2,10,3,6,5,2,3};
        System.out.println(maxProduct(nums));
    }
}
