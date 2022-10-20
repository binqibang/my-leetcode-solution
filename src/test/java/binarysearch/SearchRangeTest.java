package binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchRangeTest {
    private SearchRange sr;

    @BeforeEach
    void setUp() {
        sr = new SearchRange();
    }

    @Test
    void searchRange() {
        int[] nums = new int[] {5, 7, 7, 8, 8, 8, 9, 10};
        int target = 8;
        int[] ans = new int[] {3, 5};
        Assertions.assertArrayEquals(ans, sr.searchRange(nums, target));

        int[] nums1 = new int[] {5};
        int target1 = 5;
        sr.searchRange(nums1,target1);
    }
}