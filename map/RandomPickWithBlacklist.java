package map;

import java.util.*;

/**
 * LeetCode #710 (Hard)
 * @author binqibang
 * @date 2022/6/26
 */
public class RandomPickWithBlacklist {
    private final Map<Integer,Integer> black2white = new HashMap<>();;
    private final Random random = new Random();
    private int whiteLength;

    /**
     * 把`n`分成两部分，前`n-blackLength`部分是白名单，后`blackLength`部分是黑名单<br>
     * 对于前半部分位于黑名单中的数，建立从黑到白的映射 <br>
     * [0, (1), (2), | 3, (4), 5], black = [1, 2, 4], map； 1 -> 3, 2 -> 5
     * @param n indicate the entire array of [0, n-1]
     * @param blacklist an array of unique integers which can't be chosen
     */
    public RandomPickWithBlacklist(int n, int[] blacklist) {
        int blackLength = blacklist.length;
        // 对于后半部分，黑名单数标`1`，非黑标`0`
        int[] blackFlag = new int[blackLength];
        // 后半部分白名单数的下标
        whiteLength = n - blacklist.length;
        List<Integer> whiteIdx = new ArrayList<>();
        for (int val : blacklist) {
            if (val >= whiteLength) {
                blackFlag[val - whiteLength] = 1;
            }
        }
        for (int i = 0; i < blackLength; i++) {
            if (blackFlag[i] == 0) {
                whiteIdx.add(i);
            }
        }
        int idx = 0;
        for (int val : blacklist) {
            if (val < whiteLength) {
                black2white.put(val, whiteLength + whiteIdx.get(idx++));
            }
        }
    }

    public int pick() {
        int i = random.nextInt(whiteLength);
        return black2white.getOrDefault(i, i);
    }

}
