package tree.trie;

/**
 * LeetCode #676 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/12/5
 */
public class ArrayTrie {
    /**
     * 本题只涉及到小写字符，因此可以用长度为26的孩子数组。可能会感到奇怪，Trie 类中
     * 为什么没有用于保存数据的属性？实际上孩子数组下标就隐含了小写字符数据
     */
    ArrayTrie[] children;
    /**
     * 表示该结点是否为字符串结尾
     */
    boolean isEnd;

    public ArrayTrie() {
        children = new ArrayTrie[26];
        isEnd = false;
    }

    public void insert(String word) {
        ArrayTrie root = this;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (root.children[idx] == null) {
                root.children[idx] = new ArrayTrie();
            }
            root = root.children[idx];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        ArrayTrie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private ArrayTrie searchPrefix(String prefix){
        ArrayTrie root = this;
        for (char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            if (root.children[idx] == null){
                return null;
            }
            root = root.children[idx];
        }
        return root;
    }
}
