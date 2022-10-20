package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Trie definition
     */
    class Trie {
        Map<Character, Trie> children;

        public Trie() {
            children = new HashMap<>();
        }
    }

    public String replaceWords1(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            Trie cur = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ", words);
    }

    public String findRoot(String word, Trie trie) {
        StringBuilder root = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return root.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            root.append(c);
            cur = cur.children.get(c);
        }
        return root.toString();
    }

}
