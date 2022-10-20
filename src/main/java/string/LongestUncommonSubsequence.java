package string;


import javax.xml.stream.FactoryConfigurationError;

/**
 * LeetCode #521 (Easy); #522 (Medium)
 * @author binqibang
 * @date 2022/6/27
 */
public class LongestUncommonSubsequence {
    /**
     * 此题题目很有迷惑性，实际上如果`a`的长度大于`b`，那`a`必不可能
     * 是`b`的子序列，而它又是自身的子序列，所以此题实际上只需要判断
     * 字符串是否相等，不相等则返回较长字符串的长度
     * @return the length of the longest uncommon subsequence between `a` and `b`
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    /**
     * 双重循环判断每个字符是否是其他字符的子序列，如果不是，
     * 则其是一个“特殊序列”。最后返回所有特殊序列的最长长度。
     * @param strs an array of strings
     * @return the length of the longest uncommon subsequence of all strings of `strs`
     */
    public int findLUSlength2(String[] strs) {
        int n = strs.length;
        int res = -1;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && isSubSeq(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    /**
     * 双指针法遍历两个字符串，如果`a`中所有字符都在`b`中出现，
     * 则`a`是`b`的子序列。
     * @param a string a
     * @param b string b
     * @return true if `a` is a subsequence of `b`
     */
    public boolean isSubSeq(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        }
        int pt1 = 0, pt2 = 0;
        while (pt1 < a.length() && pt2 < b.length()) {
            // 双指针指向同一字符，都向后移动
            // 否则只有`b`指针向后移
            if (a.charAt(pt1) == b.charAt(pt2)) {
                pt1++;
            }
            pt2++;
        }
        return pt1 == a.length();
    }
}
