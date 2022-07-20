package simulation.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #731 (Medium)
 * @author binqibang
 * @date 2022/7/19
 */
public class MyCalendarTwo {
    /** 记录已经预定过的日程 */
    List<int[]> booked;

    /** 记录二重预订的的日程 */
    List<int[]> overlapped;

    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlapped = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int[] cur = new int[] {start, end};
        for (int[] schedule : overlapped) {
            if (end > schedule[0] && start < schedule[1]) {
                return false;
            }
        }
        for (int[] schedule : booked) {
            if (end > schedule[0] && start < schedule[1]) {
                overlapped.add(new int[] {Math.max(start, schedule[0]), Math.min(end, schedule[1])});
            }
        }
        booked.add(cur);
        return true;
    }
}
