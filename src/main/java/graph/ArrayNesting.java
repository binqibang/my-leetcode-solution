package graph;

/**
 * LeetCode #565
 * @author binqibang
 * @date 2022/7/17
 */
public class ArrayNesting {
    /**
     * 对于 o~n-1 的数列且每个数字出现一次的数组必然构成一个或者多个独立的环形,
     * 因此每个元素实际上只需要访问一次，DFS找到最大环即可。
     * <br>
     * Time: O(n); Space: O(1)
     */
    public int arrayNesting(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int idx = i;
            while (nums[idx] < n) {
                int num = nums[idx];
                // 标记已访问
                nums[idx] = n;
                idx = num;
                count++;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
