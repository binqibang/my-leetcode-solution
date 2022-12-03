package binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {
    private BinarySearch bs;

    @BeforeEach
    void setUp() {
        bs = new BinarySearch();
    }

    @Test
    void searchInsert() {
        int[] nums = new int[] {1, 3, 5, 7, 9};
        int target = 4;
        System.out.println(bs.searchInsert(nums, target));
    }

    @Test
    void searchLeftIdx() {
        int[] nums = new int[] {1, 3, 3, 7, 9};
        int target = 3;
        System.out.println(bs.searchRange(nums, target, true));
    }

    @Test
    void searchRightIdx() {
        int[] nums = new int[] {1, 3, 3, 7, 9};
        int target = 0;
        System.out.println(bs.searchRange(nums, target, false));
    }
}