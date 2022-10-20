package stack;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {

    @Test
    void isValid() {
        ValidParentheses vp = new ValidParentheses();
        String s = "{}{{[[]]()}}";
        System.out.println(vp.isValid(s));
    }
}