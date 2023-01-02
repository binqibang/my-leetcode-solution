package weekly;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode Weekly-Contest-326
 * @author binqibang
 * @date 2023/1/2
 */
public class Week326 {
    /**
     * #6278
     * @TimeComplexity O(n)
     */
    public int countDigits(int num) {
        int count = 0;
        int cur = num;
        while (cur != 0) {
            int digit = cur % 10;
            cur = cur / 10;
            if (num % digit == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * #2521
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(n)
     */
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 分解质因数算法
            int k = 2;
            while (k <= num) {
                if (num % k == 0) {
                    set.add(k);
                    num = num / k;
                } else {
                    k++;
                }
            }
        }
        return set.size();
    }

    /**
     * #6196
     * @TimeComplexity O(n)
     */
    public int minimumPartition(String s, int k) {
        int n = s.length(), ans = 0, idx = 0;
        long num;
        while (idx < n) {
            if (s.charAt(idx) - '0' > k) {
                return -1;
            }
            num = 0;
            while (idx < n && num <= k) {
                num = num * 10 + s.charAt(idx++) - '0';
                if (num > k) {
                    idx--;
                }
            }
            ans++;
        }
        return ans;
    }
}
