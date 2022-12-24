package dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class WordBreakTest {

    @Test
    void wordBreak() {
        WordBreak wb = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        Assertions.assertTrue(wb.wordBreak(s, wordDict));
    }
}