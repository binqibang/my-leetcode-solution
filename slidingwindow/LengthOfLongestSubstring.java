package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #3 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/8/24
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indices = new HashMap<>();
        int left = 0, ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (indices.containsKey(ch)) {
                left = Math.max(left, indices.get(ch) + 1);
            }
            ans = Math.max(ans, right - left + 1);
            indices.put(ch, right);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
