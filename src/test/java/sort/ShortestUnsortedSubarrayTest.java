package sort;

import org.junit.jupiter.api.Test;

class ShortestUnsortedSubarrayTest {

    @Test
    void findUnsortedSubarray() {
        ShortestUnsortedSubarray sus = new ShortestUnsortedSubarray();
        int[] nums1 = new int[] {1, 2, 3, 4};
        int[] nums2 = new int[] {2, 6, 4, 8, 10, 9, 15};
//        sus.findUnsortedSubarray1(nums1);
        sus.findUnsortedSubarray1(nums2);
    }
}