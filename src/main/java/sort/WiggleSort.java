package sort;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;

/**
 * LeetCode #324 (Medium)
 * @author binqibang
 * @date 2022/6/28
 */
public class WiggleSort {
    /**
     * 由于题目说明0 <= nums[i] <= 5000，
     * 可以用桶排序 <br>
     * Time: O(n); Space: O(C), C=5001
     */
    public void wiggleSort1(int[] nums) {
        int[] buckets = new int[5001];
        for (int num : nums) {
            buckets[num]++;
        }
        int idx = 5000;
        // 奇数位放大值
        for (int i = 1; i < nums.length; i+=2) {
            while (buckets[idx] == 0){
                idx--;
            }
            nums[i] = idx;
            buckets[idx]--;
        }
        // 偶数位放小值
        for (int i = 0; i < nums.length; i+=2) {
            while (buckets[idx] == 0){
                idx--;
            }
            nums[i] = idx;
            buckets[idx]--;
        }
    }

    /**
     * 先排序，而后直观想法是由后往前插入，但时间复杂度太高，
     * 因此采用辅助数组，以空间换时间 <br>
     * Time: O(nlogn); Space: O(n)
     * @param nums 待排序数组
     */
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        var back = nums.clone();
        int n = nums.length;
        int left = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            // 奇数位较小值
            if (i % 2 == 0) {
                nums[i] = back[left];
                left--;
            } else {
                // 偶数位较大值
                nums[i] = back[right];
                right--;
            }
        }
    }

}
