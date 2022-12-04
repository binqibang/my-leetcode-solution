package string;

/**
 * LeetCode #1796 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/12/3
 */
public class SecondHighestDigit {
    public int secondHighest(String s) {
        int first = -1, second = -1;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                int digit = c - '0';
                if (digit > first) {
                    second = first;
                    first = digit;
                } else if (digit < first && digit > second) {
                    second = digit;
                }
            }
        }
        return second;
    }
}
