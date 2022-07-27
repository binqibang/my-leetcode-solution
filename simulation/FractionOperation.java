package simulation;

/**
 * LeetCode #592 (Medium)
 */
public class FractionOperation {
    public static String fractionAddition(String expression) {
        // 分子，分母
        long denominator = 0, numerator = 1;
        int idx = 0, n = expression.length();
        while (idx < n) {
            // 读取分子
            // sign 加法/减法
            long denominator1 = 0, sign = 1;
            var ch = expression.charAt(idx);
            if (ch == '+' || ch == '-') {
                sign = ch == '-' ? -1 : 1;
                idx++;
            }
            while (idx < n && Character.isDigit(expression.charAt(idx))) {
                denominator1 = denominator1 * 10 + expression.charAt(idx) - '0';
                idx++;
            }
            denominator1 = sign * denominator1;
            idx++;

            // 读取分母
            long numerator1 = 0;
            while (idx < n && Character.isDigit(expression.charAt(idx))) {
                numerator1 = numerator1 * 10 + expression.charAt(idx) - '0';
                idx++;
            }
            // 计算
            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;

        }
        if (denominator == 0) {
            return "0/1";
        }
        // 获取最大公约数
        long g = gcd(Math.abs(denominator), numerator);
        return denominator / g + "/" + numerator / g;
    }

    private static long gcd(long a, long b) {
        long reminder = a % b;
        while (reminder != 0) {
            a = b;
            b = reminder;
            reminder = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        String expression = "1/3+23/8-3/4";
        System.out.println(fractionAddition(expression));
    }
}
