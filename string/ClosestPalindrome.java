package string;

/**
 * Question: LeetCode #564 (Hard)
 * @author binqibang
 * @date 2022/3/2
 */

public class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        int length = n.length();
        // 输入数字长度为 1，返回 n-1
        // 如：输入9，返回结果8
        if (length == 1) {
            return String.valueOf(Integer.parseInt(n) - 1);
        }
        // 输入数字为 10 的幂，返回 n - 1
        // 如：输入1000，返回 999
        // n 的范围为[1, 10^18-1]，故这里用 long 表示
        long num = Long.parseLong(n);


        return "";
    }
}
