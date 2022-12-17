package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MergeSortedArrayTest {

    @Test
    void merge() {
        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {2, 5, 6};
        msa.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}