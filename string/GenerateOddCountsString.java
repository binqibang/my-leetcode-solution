package string;

/**
 * LeetCode #1374 (Easy)
 * @author binqibang
 * @date 2022/8/1
 */
public class GenerateOddCountsString {
    public static String generateTheString(int n) {
        if (n % 2 != 0) {
            return "x".repeat(n);
        }
        return "x".repeat(n - 1) + "y";
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateTheString(n));
    }
}

