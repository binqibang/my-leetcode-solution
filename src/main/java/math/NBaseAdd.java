package math;

import java.util.Scanner;

public class NBaseAdd {
    private static final int N = 36;

    public static String add(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        int carry = 0;
        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            if (p1 >= 0) {
                char digit1 = num1.charAt(p1);
                carry += Character.isDigit(digit1) ? digit1 - '0' : digit1 - 'a' + 10;
                p1--;
            }
            if (p2 >= 0) {
                char digit2 = num2.charAt(p2);
                carry += Character.isDigit(digit2) ? digit2 - '0' : digit2 - 'a' + 10;
                p2--;
            }
            int cur = carry % N;
            ans.append(cur < 10 ? (char) (cur + '0') : (char) (cur - 10 + 'a'));
            carry /= N;
        }
        return ans.reverse().toString();
    }

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        String num1 = input[0], num2 = input[1];
        System.out.println(add(num1, num2));
    }
}
