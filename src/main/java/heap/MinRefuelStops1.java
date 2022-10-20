package heap;

import dp.MinRefuelStops;

import java.util.PriorityQueue;

/**
 * LeetCode #871, another solution {@link MinRefuelStops}
 * @author binqibang
 * @date 2022/7/2
 */
public class MinRefuelStops1 {
    /**
     * 题目要求我们计算最低的加油次数，因此需要每次加油都
     * 尽可能加最多的油才能保证单次加油走的更远并且加油次数最少。
     * <br>
     * 因此我们维护一个优先队列（最大堆），每次路过加油站先不加油，
     * 将加油站的油量放入最大堆中，当油量不够走到下一个加油站时，
     * 我们选择加堆中最多的油（也就是堆顶元素），直到他能够走到
     * 下一个加油站或者目的地target；当堆为空仍然无法到达时，表示
     * 无法到达目的地，返回-1，否则返回加油的次数。
     * <br>
     * Time: O(nlogn); Space: O(n)
     */
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0, idx = 0;
        int curFuel = startFuel;
        while (curFuel < target) {
            // 当前油量可以支撑到下一个加油站，不加油
            if (idx < stations.length && curFuel >= stations[idx][0]) {
                heap.add(stations[idx][1]);
                idx++;
            } else {
                // 无法到达或已经没有加油站
                if (!heap.isEmpty()) {
                    // 堆中还有油可加
                    curFuel += heap.poll();
                    ans++;
                } else {
                    // 无油可加
                    return -1;
                }
            }
        }
        return ans;
    }
}
