package heap;

import java.util.*;

/**
 * LeetCode #347 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/4
 */
public class TopKFrequentElements {
    /**
     * 方法一：哈希表记录后进行排序
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry> list = new ArrayList<>(frequency.entrySet());
        list.sort((e1, e2) -> (int) e2.getValue() - (int) e1.getValue());
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = (int) list.get(i).getKey();
        }
        return ans;
    }

    /**
     * 方法二：哈希表记录后建立小根堆
     * @TimeComplexity O(nlogk)
     * @SpaceComplexity O(n)
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(e -> e[1])
        );
        for (var entry : frequency.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            if (minHeap.size() == k) {  // 遇见更大的数，更新堆顶
                if (minHeap.peek()[1] < cnt) {
                    minHeap.poll();
                    minHeap.offer(new int[] {num, cnt});
                } else {                // 未满 k 个，直接入堆
                    minHeap.offer(new int[] {num, cnt});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll()[0];
        }
        return ans;
    }

    /**
     * 方法二：哈希表记录后建立大根堆
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(n)
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2[1] - e1[1]
        );
        for (var entry : frequency.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            maxHeap.offer(new int[] {num, cnt});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll()[0];
        }
        return ans;
    }
}
