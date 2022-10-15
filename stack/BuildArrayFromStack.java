package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #1441 (Easy)
 * @author binqibang
 * @date 2022/10/15
 */
public class BuildArrayFromStack {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int cur = 1;
        for (int num : target) {
            while (cur < num) {
                cur += 1;
                ans.add("Push");
                ans.add("Pop");
            }
            ans.add("Push");
            cur += 1;
        }
        return ans;
    }
}
