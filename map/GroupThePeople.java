package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode #1282 (Medium)
 * @author binqibang
 * @date 2022/8/12
 */
public class GroupThePeople {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int k : map.keySet()) {
            List<Integer> list = map.get(k), group = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                group.add(list.get(i));
                if (group.size() == k) {
                    ans.add(group);
                    group = new ArrayList<>();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,3,3,3,3,1,3};
        System.out.println(groupThePeople(test));
    }
}
