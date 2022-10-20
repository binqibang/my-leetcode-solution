package greedy;

/**
 * LeetCode #1413 (Easy)
 * @author binqibang
 * @date 2022/8/9
 */
public class MinStartValue {
    /**
     * 枚举法，题解范围 1~10001
     */
    public static int minStartValue(int[] nums) {
        int ans = 0;
        // 最小值 1
        // 最大值 10001，1 <= nums.length <= 100， -100 <= nums[i] <= 100
        for (int i = 1; i <= 10001; i++) {
            boolean flag = true;
            int sum = i;
            for (int num : nums) {
                sum += num;
                if (sum < 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 贪心算法，找到最小的前缀和 min，满足题意最小解即为 -min + 1
     */
    public static int minStartValue1(int[] nums) {
        int sum = 0;
        int min = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return -min + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-3,2,-3,4,2};
        System.out.println(minStartValue(nums));
    }
}
