package math;

/**
 * LeetCode #1175 (Easy)
 * @author binqibang
 * @date 2022/6/30
 */
public class PrimeArrangements {

    private static final int MOD = 1000000007;

    /**
     * 简单的全排列问题，质数在质数下标中全排列，非质数在其他位置
     * 全排列，即A(x, x) * A(n-x, n-x)，x 为质数个数
     */
    public int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        long ans = factorial(primeCount) * factorial(n-primeCount);
        return (int) (ans % MOD);
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
            // 注意这里也要取模
            ans %= MOD;
        }
        return ans;
    }
}
