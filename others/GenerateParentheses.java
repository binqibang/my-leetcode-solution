package others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode #22 (Medium); CodeTop MS
 * @author binqibang
 * @date 2021/10/13
 */
public class GenerateParentheses {
    /**
     * Time: O(n^2); Space: O(n)
     * @param n pairs of parentheses
     * @return all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        if (n == 1) {
            return List.of("()");
        }
        Set<String> set = new HashSet<>();
        for (String str : generateParenthesis(n-1)) {
            int len = str.length();
            for (int i = 0; i <= len / 2 ; i++) {
                set.add(str.substring(0,i) + "()" + str.substring(i));
            }
        }
        return new ArrayList<>(set);
    }
}
