package simulation.calendar;

import java.util.TreeMap;

/**
 * Question: LeetCode #729 (Medium)
 * Solution1: time O(logn); space O(n)
 * @author binqibang
 * @date 2022/6/6
 */
public class MyCalendarTreeMap {
    TreeMap<Integer, Integer> schedules;

    public MyCalendarTreeMap() {
        this.schedules = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        // floorKey: return the greatest key less than or equal to key
        // ceilingKey: return the least key greater than or equal to key
        Integer prev = schedules.floorKey(start),
                next = schedules.ceilingKey(start);
        if ((prev == null || schedules.get(prev) <= start) && (next == null || end <= next)) {
            schedules.put(start, end);
            return true;
        }
        return false;
    }
}
