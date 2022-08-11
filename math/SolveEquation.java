package math;

/**
 * LeetCode #640 (Medium)
 * @author binqibang
 * @date 2022/8/10
 */
public class SolveEquation {
    /**
     * 遍历方程，等式右边移项（变号），合并同类项，整理为 <br>
     * factor * x = val 的形式 <br>
     * Time: O(n); Space: O(1)
     * @param equation 字符串形式方程
     * @return 字符串形式解，"x={answer}"
     */
    public static String solveEquation(String equation) {
        // factor 表示变量的系数，val 表示常量值
        int factor = 0, val = 0;
        int index = 0, n = equation.length();
        // 等式左边默认系数为正
        int initialSign = 1;
        while (index < n) {
            if (equation.charAt(index) == '=') {
                // 等式右边默认系数为负
                initialSign = -1;
                index++;
            }
            int curSign = initialSign, number = 0;
            // 记录 x 前是否有系数
            boolean valid = false;
            // 去除运算符
            if (equation.charAt(index) == '+' || equation.charAt(index) == '-') {
                curSign = equation.charAt(index) == '-' ? -initialSign : initialSign;
                index++;
            }
            while (index < n && Character.isDigit(equation.charAt(index))) {
                number = number * 10 + (equation.charAt(index) - '0');
                index++;
                valid = true;
            }
            if (index < n && equation.charAt(index) == 'x') {   // 变量
                factor += valid ? curSign * number : curSign;
                index++;
            } else {    // 数值
                val += curSign * number;
            }
        }
        if (factor == 0) {
            return val == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + (-val / factor);
    }

    public static void main(String[] args) {
        String test = "x+5-3+x=6+x-2";
        System.out.println(solveEquation(test));
    }
}
