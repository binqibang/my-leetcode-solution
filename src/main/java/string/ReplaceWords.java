package string;

import java.util.List;

/**
 * LeetCode #648 (Medium)
 * @author binqibang
 * @date 2022/7/7
 */
public class ReplaceWords {
    /**
     * 枚举，使用了`startsWith`标准库
     * <br>
     * Time: O(m*n); Space: O(1)
     * @param dictionary consisting of many roots
     * @param sentence  consisting of words separated by spaces,
     * @return replace all the successors in the sentence with the root
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder builder = new StringBuilder();
        var words = sentence.split(" ");
        for (var word : words) {
            String minRoot = word;
            for (var curRoot : dictionary) {
                if (word.startsWith(curRoot)) {
                    minRoot = curRoot.length() < minRoot.length() ? curRoot : minRoot;
                }
            }
            builder.append(minRoot).append(" ");
        }
        // 去除最后一个空格
        builder.delete(builder.length()-1, builder.length());
        return builder.toString();
    }

}
