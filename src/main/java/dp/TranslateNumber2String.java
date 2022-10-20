package dp;

/**
 * 《剑指offer》#46 (Medium)
 * @author binqibang
 * @date 2022/6/25
 */
public class TranslateNumber2String {
    public static int translateNum(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int[] dp = new int[n];
        dp[0] = 1;
        if (n == 1) {
            return dp[0];
        }
        dp[1] = numStr.substring(0,2).compareTo("25") <= 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            String tmp = numStr.substring(i-1, i);
            String tmp1 = numStr.substring(i-1, i+1);
            if (tmp.compareTo("0") > 0 && tmp1.compareTo("25") <= 0) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int test = 61351193;
        System.out.println(translateNum(test));
    }
}
