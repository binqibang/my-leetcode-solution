package math;

/**
 * LeetCode #69 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/11/26
 */
public class MySqrt {
    /**
     * 方法一：二分查找
     * @param x non-negative integer.
     * @return the square root of x rounded down to the nearest integer.
     * @TimeComplexity O(logn)
     */
    public int mySqrt(int x) {
        int left = 1, right = x, ans = 0;
        while (left <= right) {
             int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 方法二：牛顿迭代法
     * @TimeComplexity O(logn)
     */
    public int mySqrt1(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x, epsilon = 1e-7;
        while (true) {
            double xi = (x0 + C / x0) * 0.5;
            if (Math.abs(xi - x0) < epsilon) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
