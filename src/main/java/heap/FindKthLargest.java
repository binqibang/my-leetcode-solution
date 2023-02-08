package heap;

import java.util.PriorityQueue;

/**
 * LeetCode #215 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/8/23
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        // 建立大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        // 去掉前 k - 1 个堆顶元素
        for (int i = 0; i < k - 1; i ++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static int findKthLargest1(int[] nums, int k) {
        // 建立小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        // 前 k 个元素建堆
        for (; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        // 遇见更大的数，更新堆顶
        for (; i < nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 1;
        System.out.println(findKthLargest1(nums, k));
    }
}
