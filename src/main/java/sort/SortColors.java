package sort;

/**
 * LeetCode #75 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/16
 */
public class SortColors {
    /**
     * 解法一：计数排序
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    public void sortColors(int[] nums) {
        final int COLORS = 3;
        int[] counts = new int[COLORS];
        for (int num : nums) {
            counts[num]++;
        }
        int idx = 0;
        for (int i = 0; i < COLORS; i++) {
            while (counts[i] != 0) {
                nums[idx++] = i;
                counts[i]--;
            }
        }
    }
}
