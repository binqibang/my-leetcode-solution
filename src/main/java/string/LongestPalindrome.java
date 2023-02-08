package string;

/**
 * LeetCode #5 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/23
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        int left, right;
        // 当前串长度初始化为单个字符长度
        int curLen = 1, maxLen = 0;
        // 记录最大回文串的起始位置
        int maxStart = 0;
        for (int i = 0; i < n; i++) {
            left = i - 1;
            right = i + 1;
            // 向左扩散直到不同字符
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                curLen++;
                left--;
            }
            // 向右扩散直到不同字符
            while (right < n && s.charAt(right) == s.charAt(i)) {
                curLen++;
                right++;
            }
            // 左右双向扩散直到左右字符不同
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                curLen += 2;
                left--;
                right++;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
                maxStart = left + 1;
            }
            curLen = 1;
        }
        return s.substring(maxStart, maxStart + maxLen);
    }
}
