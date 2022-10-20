package others;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenerateParenthesesTest {
    private GenerateParentheses gp;

    @BeforeEach
    void setUp() {
        gp = new GenerateParentheses();
    }

    @Test
    void generateParenthesis() {
        System.out.println(gp.generateParenthesis(3));
    }
}