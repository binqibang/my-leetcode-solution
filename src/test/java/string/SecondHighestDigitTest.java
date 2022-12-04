package string;

import org.junit.jupiter.api.Test;

class SecondHighestDigitTest {

    @Test
    void secondHighest() {
        SecondHighestDigit shd = new SecondHighestDigit();
        String s = "dfa22221afd";
        System.out.println(shd.secondHighest(s));
    }
}