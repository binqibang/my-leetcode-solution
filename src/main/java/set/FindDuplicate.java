package set;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #287 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/3
 */
public class FindDuplicate {
    /**
     * 方法一：使用 Set
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n)
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = nums[0];
        for (int num : nums) {
            if (set.contains(num)) {
                ans = num;
            }
            set.add(num);
        }
        return ans;
    }

    /**
     * 方法一：快慢指针
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
