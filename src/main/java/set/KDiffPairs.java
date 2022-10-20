package set;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #532 (Medium)
 * @author binqibang
 * @date 2022/6/16
 */
public class KDiffPairs {
    /**
     * 暴力解法，遍历求`diff`，用集合存储数对<br>
     * Time: O(n^2); Space: O(n^2)
     * @param nums
     * @param k
     * @return 满足 k-diff 的数对数
     */
    public static int findPairs1(int[] nums, int k) {
        Set<Integer> pairs = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                if (diff == k) {
                    pairs.add(nums[i] > nums[j]? nums[i]:nums[j]);
                }
            }
        }
        return pairs.size();
    }

    /**
     * 解法一优化，双集合，因为k定值，故只需遍历一遍<br>
     * 最后的结果集也只需存储较小的数即可 <br>
     * Time: O(n); Space: O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs2(int[] nums, int k) {
        // 确定初始容量，省去扩容时间
        // 将已遍历元素也存入集合，减少计算`diff`的时间
        Set<Integer> visited = new HashSet<>((int) 1e4);
        Set<Integer> res = new HashSet<>((int) 1e4);
        for (int num : nums) {
            if (visited.contains(num - k)) {
                // 存较小元素即可，因为`k`固定
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }

    /**
     * 排序+双指针<br>
     * 同样解法参见 {@link binarysearch.KthSmallestPairDistance}
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs3(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, res = 0;
        for (int i = 0; i < n - 1 ; i++) {
            // 保持 i < j < n
            int j = i + 1;
            // 重复元素不计算
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (j < n && (nums[j] < nums[i] + k)) {
                j++;
            }
            // 找到目标值
            if (j < n && nums[j] == nums[i] + k) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,1,5,4};
        int k = 1;
        System.out.println(findPairs1(nums, k));
        System.out.println(findPairs3(nums, k));
    }
}
