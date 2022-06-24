package dp;

import java.util.Scanner;

/**
 * Question: LeetCode #926 (Medium)
 * @author binqibang
 * @date 2022/6/11
 */
public class FlipStringToMonoIncr {
    public static int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int dp0 = 0, dp1 = 0;
        for(char ch : chars) {
            // i-th char -> '1'
            dp1 = Math.min(dp0, dp1) + (ch == '1' ? 0 : 1);
            // i-th char -> '0'
            dp0 += (ch == '0' ? 0 : 1);
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var test = scanner.nextLine();
        System.out.println(minFlipsMonoIncr(test));
    }
}
