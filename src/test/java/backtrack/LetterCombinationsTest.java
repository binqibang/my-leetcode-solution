package backtrack;

import org.junit.jupiter.api.Test;

class LetterCombinationsTest {

    @Test
    void letterCombinations() {
        LetterCombinations lc = new LetterCombinations();
        String digits = "245";
        System.out.println(lc.letterCombinations(digits));
    }
}