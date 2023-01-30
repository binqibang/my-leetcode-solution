package weekly;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode Weekly-Contest-328
 * @author binqibang
 * @date 2023/1/15
 */
public class Week328 {
    public int differenceOfSum(int[] nums) {
        int elementSum = 0, digitSum = 0;
        for (int num : nums) {
            elementSum += num;
            String s = String.valueOf(num);
            for (char digit : s.toCharArray()) {
                digitSum += (digit - '0');
            }
        }
        return Math.abs(elementSum - digitSum);
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[2]; i++) {
                for (int j = q[1]; j <= q[3]; j++) {
                    mat[i][j]++;
                }
            }
        }
        return mat;
    }

    public long countGood(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, l = 0, n = nums.length;
        for (int r = 0; r < n; r++) {
            count += map.getOrDefault(nums[r], 0);
            map.merge(nums[r], 1, Integer::sum);    // like map[nums[r]]++
            while (count >= k) {
                ans += n - r;
                count -= map.get(nums[l]) - 1;
                map.merge(nums[l++], -1, Integer::sum); // like map[nums[l]]--
            }
        }
        return ans;
    }
}
