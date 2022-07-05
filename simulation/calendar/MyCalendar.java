package simulation.calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: LeetCode #729 (Medium)
 * 用 list 存放日程，当安排新日程时遍历所有日程对比 <br>
 * Time: O(n^2); Space: O(n)
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
