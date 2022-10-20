package slidingwindow;

/**
 * LeetCode #634 (Easy)
 * @author binqibang
 * @date 2022/7/22
 */
public class MaxAverageSubarray {
    /**
     * 滑动窗口，维护窗口内的和 <br>
     * Time: O(n); Space: O(1)
     */
    public static double findMaxAverage(int[] nums, int k) {
        double ans = -10e4;
        int l = 0, r = l + k - 1;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[l+i];
        }
        while (r < nums.length) {
            ans = Math.max(ans, sum / k);
            if (r == nums.length - 1) {
                break;
            }
            sum += nums[++r];
            sum -= nums[l++];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(test, k));
    }
}
