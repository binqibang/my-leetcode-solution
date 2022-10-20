package heap;

/**
 * LeetCode #1845 (Medium) <br>
 * 直接用数组存储，会超时 <br>
 * Time: O((q1+q2) * n); Space: O(n)
 * @author binqibang
 * @date 2022/7/26
 */
public class SeatManager {
    /**
     * seats[i] == 0, 可预约
     * seats[i] == 1, 不可预约
     */
    int[] seats;
    int n;

    public SeatManager(int n) {
        seats = new int[n+1];
        this.n = n;
    }

    public int reserve() {
        for (int i = 1; i < n + 1; i++) {
            if (seats[i] == 0) {
                seats[i] = 1;
                return i;
            }
        }
        return 0;
    }

    public void unreserve(int seatNumber) {
        seats[seatNumber] = 0;
    }
}
