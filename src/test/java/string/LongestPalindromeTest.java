package string;

import org.junit.jupiter.api.Test;

class LongestPalindromeTest {

    @Test
    void longestPalindrome() {
        LongestPalindrome lp = new LongestPalindrome();
        String s = "acdbbada";
        System.out.println(lp.longestPalindrome(s));
    }
}