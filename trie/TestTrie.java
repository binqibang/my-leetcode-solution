package trie;

import java.util.Arrays;
import java.util.List;

/**
 * Tests for package trie
 * @author binqibang
 */
public class TestTrie {
    public static void main(String[] args) {
        var test = "the cattle was rattled by the battery";
        String[] dic = new String[] {"cat","bat","rat"};
        List<String> dict = Arrays.asList(dic);
        ReplaceWords solution = new ReplaceWords();
        var res = solution.replaceWords1(dict, test);
        System.out.println(res);
    }
}
