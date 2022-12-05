package tree.trie;

import org.junit.jupiter.api.Test;

class TrieTest {

    @Test
    void testTrie() {
        ArrayTrie trie = new ArrayTrie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}