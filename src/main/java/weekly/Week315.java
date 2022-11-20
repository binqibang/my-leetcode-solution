package weekly;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Weekly-Contest-315
 * @author binqibang
 * @date 2022/10/16
 */
public class Week315 {
    public int reverse(int num) {
        String digits = String.valueOf(num);
        int ans = 0;
        for (int i = digits.length() - 1; i >= 0; i--) {
            ans = 10 * ans + digits.charAt(i) - '0';
        }
        return ans;
    }

    public int reverse1(int num) {
        int ans = 0;
        while (num > 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }
        return ans;
    }

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (-nums[l] == nums[r]) {
                return nums[r];
            } else if (-nums[l] > nums[r]) {
                l++;
            } else {
                r--;
            }
        }
        return -1;
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            res.add(num);
            String digits = String.valueOf(num);
            int reverse = reverse(num);
            res.add(reverse);
        }
        return res.size();
    }

    public boolean sumOfNumberAndReverse(int num) {
        int cur = 0;
        while (cur <= num) {
            if (cur + reverse(cur) == num) {
                return true;
            }
            cur++;
        }
        return false;
    }
}
