package string;

/**
 * LeetCode #415 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/11/8
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder builder = new StringBuilder();
        int carry = 0, reminder;
        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            reminder = carry + digit1 + digit2;
            carry = reminder / 10;
            reminder = reminder % 10;
            builder.append(reminder);
            i--;
            j--;
        }
        if (carry > 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
