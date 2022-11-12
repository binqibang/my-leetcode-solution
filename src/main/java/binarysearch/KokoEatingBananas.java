package binarysearch;

/**
 * LeetCode #857 (Medium)
 * @author binqibang
 * @date 2022/6/7
 */
public class KokoEatingBananas {
    /**
     * 二分查找应用：结果在一个范围内且具有单调性
     */
    public int minEatingSpeed(int[] piles, int h) {
        // 1 <= piles[i] <= 10^9, speed ~ int
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        int k = right;
        while (left < right) {
            int speed = (right - left) / 2 + left;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                right = speed;
            } else {
                left = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        // 1 <= piles.length <= 10^4, 1 <= piles[i] <= 109
        // time ~ 10^13 ~ long
        long time = 0;
        for (int pile : piles) {
            int curTime = (int) Math.ceil((double) pile / speed);
            time += curTime;
        }
        return time;
    }
}