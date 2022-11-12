package binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimumInRotatedSortedArrayTest {
    private MinimumInRotatedSortedArray mr;

    @BeforeEach
    void setUp() {
        mr = new MinimumInRotatedSortedArray();
    }

    @Test
    void findMin() {
        int[] nums = new int[] {4, 5, 0, 1, 2, 3};
        System.out.println(mr.findMin1(nums));
    }
}