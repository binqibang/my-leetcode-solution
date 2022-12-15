package slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LengthOfLongestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        Assertions.assertEquals(3, ls.lengthOfLongestSubstring(s));
    }
}