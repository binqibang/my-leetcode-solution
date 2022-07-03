package nextperm;

/**
 * LeetCode #31 (Medium)
 * @author binqibang
 * @date 2022/7/3
 */
public class NextPermutation {
    /**
     * 官方解法，寻找升序对 -> 寻找较大数交换 -> 反转子序列
     * <br>
     * Time: O(n); Space: O(1)
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 寻找第一对 nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // i < 0，则整个序列为降序对，直接跳转到最小排列
        // i >= 0，从右往左寻找与其交换的较大数，并交换位置
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 交换之后，[i+1, n) 必定降序，逆转其为升序
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
