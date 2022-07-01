package stack;

import java.util.Stack;

/**
 * LeetCode #1614 (Easy)
 * @author binqibang
 * @created 2022/7/1
 */
public class MaxNestingDepthOfParentheses {
    /**
     * 使用栈模拟括号的匹配，最大匹配深度即为栈最大长度<br>
     * Time: O(n); Space: O(n)
     * @param s input string
     * @return  max nesting depth of any VPS
     */
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                ans = Math.max(ans, stack.size());
            }
            if (ch == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        return ans;
    }

    /**
     * 用`size`变量模拟栈，省去了出栈入栈的时间以及空间 <br>
     * Time: O(n); Space: O(1)
     */
    public int maxDepth2(String s) {
        int ans = 0, size = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++size;
                ans = Math.max(ans, size);
            } else if (ch == ')') {
                --size;
            }
        }
        return ans;
    }
}
