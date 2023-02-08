package hashmap;

import heap.TopKFrequentElements;
import org.junit.jupiter.api.Test;

class TopKFrequentElementsTest {

    @Test
    void topKFrequent() {
        int[] nums = new int[] {4,1,-1,2,-1,2,3};
        int k = 2;
        TopKFrequentElements.topKFrequent(nums, k);
        TopKFrequentElements.topKFrequent1(nums, k);
    }
}