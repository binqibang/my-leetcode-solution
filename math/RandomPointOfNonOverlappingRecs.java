package math;

import java.util.Random;

/**
 * Question: LeetCode #497 (Medium)
 * @author binqibang
 * @date 2022/6/9
 */
public class RandomPointOfNonOverlappingRecs {
    Random random;
    int[][] rects;

    public RandomPointOfNonOverlappingRecs(int[][] rects) {
        this.random = new Random();
        this.rects = rects;
    }

    public int[] pick() {
        long curSum = 0, cur = 0;
        int idx = 0;
        for (int i = 0; i < rects.length; i++) {
            cur = (rects[i][2]-rects[i][0] + 1) * (rects[i][3]-rects[i][1] + 1);
            curSum += cur;
            if (Math.abs(random.nextLong()) % curSum < cur ) {
                idx = i;
            }
        }
        int x1 = rects[idx][0], y1 = rects[idx][1], x2 = rects[idx][2], y2 = rects[idx][3];
        return new int[]{x1 + random.nextInt(x2 - x1 + 1), y1 + random.nextInt(y2 - y1 + 1)};
    }
}
