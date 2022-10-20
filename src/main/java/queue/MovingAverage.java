package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值 (Easy)
 * @author binqibang
 * @date 2022/7/16
 */
public class MovingAverage {

    private final Queue<Integer> window;
    private final int maxSize;
    private double sum;

    public MovingAverage(int size) {
        window = new LinkedList<>();
        maxSize = size;
    }

    public double next(int val) {
        if (window.size() == maxSize) {
            sum -= window.poll();
        }
        window.offer(val);
        sum += val;
        return sum / window.size();
    }

}
