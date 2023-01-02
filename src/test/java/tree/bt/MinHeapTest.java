package tree.bt;

import org.junit.jupiter.api.Test;

class MinHeapTest {
    @Test
    void minHeapTest() {
        MinHeap minHeap = new MinHeap(7);
        minHeap.insert(21);
        minHeap.insert(12);
        minHeap.insert(9);
        minHeap.insert(3);
        minHeap.insert(13);
        minHeap.insert(7);
        minHeap.insert(16);
        minHeap.printHeap();
        minHeap.remove();
        minHeap.remove();
        minHeap.insert(2);
    }

}