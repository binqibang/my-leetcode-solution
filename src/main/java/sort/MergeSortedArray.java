package sort;

import java.util.Arrays;

public class MergeSortedArray {
    /**
     * 解法一：从头归并，需要辅助数组
     * @TimeComplexity O(m+n)
     * @SpaceComplexity (m)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, m);
        int p1 = 0, p2 = 0, idx = 0;
        while (p1 < m || p2 < n) {
            if (p2 >= n || (p1 < m && nums1Copy[p1] <= nums2[p2])) {
                nums1[idx++] = nums1Copy[p1++];
            } else {
                nums1[idx++] = nums2[p2++];
            }
        }
    }

    /**
     * 解法二：从后向前归并，不需要辅助数组
     * @TimeComplexity O(m+n)
     * @SpaceComplexity (1)
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, idx = nums1.length - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[idx--] = nums2[p2--];
            } else {
                nums1[idx--] = nums1[p1--];
            }
        }
    }
}
