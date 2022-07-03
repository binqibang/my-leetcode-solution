package nextperm;

/**
 * LeetCode #556 (Medium)
 * @author binqibang
 * @date 2022/7/3
 */
public class NextGreaterElement3 {
    /**
     * 解法参考{@link NextPermutation}
     * <br>
     * Time: O(C); Space: O(C)，C为输入整数字符串长度
     */
    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = nums.length - 1;
        while (j >=0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i+1);
        long ans = Long.parseLong(String.valueOf(nums));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(char[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
