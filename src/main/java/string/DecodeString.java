package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode #394 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/8
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> operStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        int oper = 0;
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                oper = oper * 10 + c - '0';
            } else if (c == '[') {
                strStack.push(str);
                operStack.push(oper);
                str = new StringBuilder();
                oper = 0;
            } else if (Character.isAlphabetic(c)) {
                str.append(c);
            } else {    // ']'
                StringBuilder tmp = strStack.pop();
                int curr = operStack.pop();
                tmp.append(String.valueOf(str).repeat(Math.max(0, curr)));
                str = tmp;
            }
        }
        return str.toString();
    }
}
