/**
 * LeetCode #121 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/9/27
 */
public class MaxProfit {
    /**
     * Time: O(n^2)
     * @param prices prices[i] is the price of a given stock on the i-th day
     * @return maximum profit
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    int curProfit = prices[j] - prices[i];
                    maxProfit = Math.max(curProfit, maxProfit);
                }
            }
        }
        return maxProfit;
    }

    /**
     * 假如计划在第 i 天卖出股票，那么最大利润一定是在 [0, i-1] 之间选最低点买入；
     * 所以遍历数组，依次求每个卖出时机的的利润，再从中取最大值。
     */
    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
