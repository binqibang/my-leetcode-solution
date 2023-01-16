package weekly;

import org.junit.jupiter.api.Test;

class Week328Test {

    @Test
    void countGood() {
        Week328 week328 = new Week328();
        int[] nums = new int[] {3,1,4,3,2,2,4};
        int k = 2;
        System.out.println(week328.countGood(nums, k));
    }
}