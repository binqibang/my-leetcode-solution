package math;

import java.util.Scanner;

/**
 * Question: LeetCode #829 (Hard)
 * @author binqibang
 * @date 2022/6/3
 */
public class ConsecutiveNumbersSum {
    public static int consecutiveNumbersSum(int n) {
        // Actually n = x + (x+1) + (x+2) + ... + (x+i-1),
        // n = ix + (1 + 2 + 3 + 4 +...+ i-1), x >= 1, i >= 1
        // let 1 + 2 + 3 + 4 +...+ i-1 = sum, then (n - sum) % i = 0
        int sum = 0, ans = 0;
        for (int i = 1; sum < n; i++) {
            if ((n - sum) % i == 0) {
                // print these numbers
                int x = (n - sum) / i;
                int cur = x;
                while (cur <= n) {
                    System.out.print(x + " ");
                    cur += x;
                    x++;
                }
                System.out.println();
                ans++;
            }
            sum += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var test = input.nextInt();
        System.out.println("The answer is: " + consecutiveNumbersSum(test));
    }
}
