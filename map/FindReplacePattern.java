package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Question: LeetCode #890 (Medium)
 * @author binqibang
 * @date 2022/6/12
 */
public class FindReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            // 轮流作 word, pattern
            // 逆向思维
            if (isPattern(word, pattern) && isPattern(pattern, word)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean isPattern(String word, String pattern) {
        HashMap<Character, Character> permutation = new HashMap<>();
        int n = pattern.length();
        for (int i = 0; i < n; i++) {
            char key = word.charAt(i);
            char value = pattern.charAt(i);
            // 之前不存在同一`key`映射
            if (! permutation.containsKey(key)) {
                permutation.put(key, value);
            } else if (permutation.get(key) != value) {
                // 之前存在同一`key`映射，且新映射`value`不同
                return false;
            }
        }
        return true;
    }

}
