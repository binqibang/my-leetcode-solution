package string;

import java.util.Arrays;
import java.util.Collections;

/**
 * LeetCode #151 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/16
 */
public class ReverseWords {
    /**
     * 调用 API
     * @param s input string with some words separated by at least one space.
     * @return reverse the order of the words.
     */
    public static String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔
        var wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords1(String s) {
        int start, end;
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            // skip space
            if (s.charAt(i) == ' ') {
                continue;
            }
            // find last non-space char (for one word)
            end = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // find first non-space char
            start = i + 1;
            for (int j = start; j <= end ; j++) {
                builder.append(s.charAt(j));
            }
            builder.append(' ');
        }
        // delete last redundant space
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = " Hello  World ";
        System.out.println(reverseWords1(s));
    }
}
