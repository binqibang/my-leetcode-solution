package weekly;

import java.util.Arrays;

/**
 * LeetCode Weekly-Contest-329
 * @author binqibang
 * @date 2023/1/23
 */
public class Week329 {
    public int alternateDigitSum(int n) {
        String digits = String.valueOf(n);
        int sign = 1, sum = 0;
        for (char digit : digits.toCharArray()) {
            sum += (digit - '0') * sign;
            sign *= -1;
        }
        return sum;
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
        return score;
    }

    public boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }

}
