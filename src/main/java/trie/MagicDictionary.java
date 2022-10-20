package trie;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #676
 * 解法一，枚举法
 * @author binqibang
 * @date 2022/7/11
 */
public class MagicDictionary {
    private final Set<String> dictSet;

    public MagicDictionary() {
        this.dictSet = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        Collections.addAll(dictSet, dictionary);
    }

    public boolean search(String searchWord) {
        boolean ans = false;
        for (String word : dictSet) {
            if (isMatched(searchWord, word)) {
                ans = true;
            }
        }
        return ans;
    }

    public boolean isMatched(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
