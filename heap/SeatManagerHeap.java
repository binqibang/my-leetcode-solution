package heap;

import java.util.PriorityQueue;

/**
 * LeetCode #1845 (Medium) <br>
 * 用最小堆存储 <br>
 * Time: O((n+q1+q2) * logn); Space: O(n)
 * @author binqibang
 * @date 2022/7/26
 */
public class SeatManagerHeap {
    PriorityQueue<Integer> seats;

    public SeatManagerHeap(int n) {
        // 默认最小堆
        this.seats = new PriorityQueue<>(n);
        for (int i = 1; i <= n ; i++) {
            seats.add(i);
        }
    }

    public int reserve() {
        return seats.poll();
    }

    public void unreserve(int seatNumber) {
        seats.add(seatNumber);
    }

}
