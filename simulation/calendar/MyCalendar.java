package simulation.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: LeetCode #729 (Medium)
 * Solution1: time O(n^2); space O(n)
 * @author binqibang
 * @date 2022/6/6
 */
public class MyCalendar {

    List<int []> schedules;

    public MyCalendar() {
        this.schedules = new ArrayList<>();
    }

    public boolean book (int start, int end) {
        for (int[] schedule:schedules) {
            if (end > schedule[0] && start < schedule[1]) {
                return false;
            }
        }
        schedules.add(new int[] {start, end});
        return true;
    }
}
