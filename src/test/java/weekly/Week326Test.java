package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Week326Test {
    private Week326 week326;

    @BeforeEach
    void setUp() {
        week326 = new Week326();
    }

    @Test
    void countDigits() {
    }

    @Test
    void distinctPrimeFactors() {
        int[] nums = new int[] {2,4,3,7,10,6};
        week326.distinctPrimeFactors(nums);
    }

    @Test
    void minimumPartition() {
        String s = "86251";
        int k = 128;
        week326.minimumPartition(s, k);
    }
}