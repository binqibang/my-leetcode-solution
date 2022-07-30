package string;

import java.util.Arrays;

/**
 * LeetCode #821 (Easy)
 * @author binqibang
 * @date 2022/7/30
 */
public class ShortestDisToChar {
    /**
     * 此题其实思路很有借鉴性，求字符串或数组间元素的 <br>
     * 最大最小距离都可以借鉴。实际上就是两次反向遍历。<br>
     * Time: O(n); Space: O(1)
     */
    public static int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        int n = s.length();
        // 求 s[i] 到其左侧 c 的最短距离
        for (int i = 0, index = -n; i < n; i++) {
            if (s.charAt(i) == c) {
                index = i;
            }
            ans[i] = i - index;
        }
        // 求 s[i] 到其右侧 c 的最短距离
        for (int i = n - 1, index = 2*n; i >= 0 ; i--) {
            if (s.charAt(i) == c) {
                index = i;
            }
            ans[i] = Math.min(ans[i], index - i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        var res = shortestToChar(s, c);
        System.out.println(Arrays.toString(res));
    }
}
