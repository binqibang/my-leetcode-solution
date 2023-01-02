package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #3 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/8/24
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        // 维护某字符上次出现的位置
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // 如果右字符已经出现过，那么将左指针移到该字符上次出现位置之后
            if (map.containsKey(ch)) {
                // 此处避免左指针往回走
                left = Math.max(left, map.get(ch) + 1);
            }
            ans = Math.max(ans, right - left + 1);
            // 更新当前字符最新出现的位置
            map.put(ch, right);
        }
        return ans;
    }
}
