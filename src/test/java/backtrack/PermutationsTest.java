package backtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PermutationsTest {
    private Permutations p;

    @BeforeEach
    void setUp() {
        p = new Permutations();
    }

    @Test
    void permute() {
        int[] nums = new int[] {1, 2, 3, 5};
        System.out.println(p.permute(nums));
    }
}