package tree.bt;

/**
 * Java 实现最小堆
 */
public class MinHeap {
    private final int[] heap;
    private int index;  // position for inserting
    private final int size;

    public MinHeap(int size) {
        this.size = size;
        heap = new int[size];
        index = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private int rightChild(int i) {
        return i * 2 + 2;
    }

    private boolean isLeaf(int i) {
        return leftChild(i) >= size && rightChild(i) >= size;
    }

    private void swap(int x, int y) {
        int tmp;
        tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    /**
     * Heapify the node at i
     */
    private void minHeapify(int i) {
        // If the node is a non-leaf node and any of its child is smaller
        if (!isLeaf(i)) {
            int lc = leftChild(i), rc = rightChild(i);
            if (heap[i] > heap[lc] || heap[i] > heap[rc]) {
                if (heap[lc] < heap[rc]) {
                    swap(i, lc);
                    minHeapify(lc);
                } else {
                    swap(i, rc);
                    minHeapify(rc);
                }
            }
        }
    }

    public void insert(int element) {
        if (index >= size) {
            return;
        }
        heap[index] = element;
        int curr = index;
        while (heap[curr] < heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
        index++;
    }

    public int remove() {
        int popped = heap[0];
        heap[0] = heap[--index];
        minHeapify(0);
        return popped;
    }

    /**
     * Builds the min-heap using the minHeapify
     */
    public void minHeap() {
        for (int i = (index - 1 / 2); i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void printHeap() {
        for (int i = 0; i < (index / 2); i++) {
            System.out.printf("Parent: %-2d ", heap[i]);
            if (leftChild(i) < index)
                System.out.printf("Left: %-2d ", heap[leftChild(i)]);
            if (rightChild(i) < index)
                System.out.printf("Right: %-2d ", heap[rightChild(i)]);
            System.out.println();
        }
    }
}
