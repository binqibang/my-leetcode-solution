package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode #20 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/10/18
 */
public class ValidParentheses {
    /**
     * Time: O(n); Space: O(n)
     * @param s a string s containing just the characters '(', ')', '{', '}', '[' and ']'
     * @return determine if the input string is valid
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        // Map 初始化
        Map<Character, Character> pairs = new HashMap<>(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {    // 左括号直接入栈
                stack.push(ch);
            } else {    // 右括号去匹配
                if (stack.isEmpty() || ch != pairs.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
