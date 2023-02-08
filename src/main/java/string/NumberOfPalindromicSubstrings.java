package string;

/**
 * LeetCode #674 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/8
 */
public class NumberOfPalindromicSubstrings {
    /**
     * 中心扩散法，需要考虑到字串长度奇偶
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(n)
     */
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int center = 0; center < n; center++) {
            // expand(s, center, center) 即字串长度为奇数，中心只有一个字符
            // expand(s, center, center + 1) 即字串长度为偶数，中心有两个字符
            ans += expand(s, center, center) + expand(s, center, center + 1);
        }
        return ans;
    }

    private int expand(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
