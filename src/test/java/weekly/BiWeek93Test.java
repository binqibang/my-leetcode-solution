package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BiWeek93Test {
    private BiWeek93 biWeek93;

    @BeforeEach
    void setUp() {
        biWeek93 = new BiWeek93();
    }

    @Test
    void maximumValue() {
    }

    @Test
    void maxStarSum() {
        int[] vals = new int[] {-1, 0};
        int[][] edges = new int[][]{};
        int k = 1;
        biWeek93.maxStarSum(vals, edges, k);
    }
}