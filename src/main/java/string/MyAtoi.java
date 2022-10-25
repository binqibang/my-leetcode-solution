package string;

/**
 * LeetCode #8 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/25
 */
public class MyAtoi {
    /**
     * 1. Read in and ignore any leading whitespace;
     * 2. Check sign char '+' '-';
     * 3. Read in next the characters until the next non-digit character,
     *    the rest of the string is ignored, convert these digits;
     * 4. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1],
     *    then clamp the integer.
     */
    public int myAtoi(String s) {
        int ans = 0, sign = 1;
        int idx = 0, n = s.length();
        // remove leading spaces
        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }
        // visit '+' or '-'
        if (idx < n && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = s.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }
        // visit digits '0' ~ '9'
        // if visits no-digit char, then finish loop
        while (idx < n && '0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
            int digit = s.charAt(idx) - '0';
            // integer overflow, clamp
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return ans * sign;
    }
}
