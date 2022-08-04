package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #1403 (Easy)
 * @author binqibang
 * @date 2022/8/4
 */
public class MinSubseqNoIncreasingOrder {
    /**
     * 排序 + 贪心，每次都选则较大的数相加，注意为了减少计算剩余元素和
     * 的时间，可以先计算出全体元素总和，这样减去当前和即可。<br>
     * Time: O(nlogn); Space: O(logn)
     */
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            ans.add(nums[0]);
            return ans;
        }
        // 计算数组元素总和
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int curSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            curSum += nums[i];
            ans.add(nums[i]);
            if (curSum > total - curSum) {
                break;
            }
        }
        return ans;
    }
}
