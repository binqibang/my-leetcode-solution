package tree.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie 的哈希表实现
 */
public class MapTrie {
    Map<Character, MapTrie> children;
    boolean isEnd;

    public MapTrie() {
        children = new HashMap<>();
        isEnd = false;
    }

    public void insert(String word) {
        MapTrie root = this;
        for (char ch : word.toCharArray()) {
            if (root.children.get(ch) == null) {
                root.children.put(ch, new MapTrie());
            }
            root = root.children.get(ch);
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        MapTrie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private MapTrie searchPrefix(String prefix) {
        MapTrie root = this;
        for (char ch : prefix.toCharArray()) {
            if (root.children.get(ch) == null) {
                return null;
            }
            root = root.children.get(ch);
        }
        return root;
    }
}
