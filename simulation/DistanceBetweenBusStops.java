package simulation;

/**
 * LeetCode #1184 (Easy)
 * @author binqibang
 * @date 2022/7/24
 */
public class DistanceBetweenBusStops {
    /**
     * 此题唯一的坑在于起点编号可以大于终点，此时交换起终点，最短距离是一样的。
     * <br>
     * Time: O(n); Space: O(1)
     * @param distance distance[i] 即编号 i 的车站和 (i + 1) % n 的车站之间的距离。
     * @param start 起点车站
     * @param destination 终点车站
     * @return 两车站之间最短距离
     */
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 顺时针距离
        int cwDis = 0;
        // 逆时针距离
        int ccwDis = 0;
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = start;
        }
        for (int i = start; i < destination; i++) {
            cwDis += distance[i];
        }
        for (int i = start - 1; i >= 0 ; i--) {
            ccwDis += distance[i];
        }
        for (int i = distance.length - 1; i >= destination; i--) {
            ccwDis += distance[i];
        }
        return Math.min(ccwDis, cwDis);
    }

    public static void main(String[] args) {
        int[] dis = new int[] {7,10,1,12,11,14,5,0};
        int s = 7, d = 2;
        System.out.println(distanceBetweenBusStops(dis, s, d));
    }
}
