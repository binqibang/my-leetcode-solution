package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Week325Test {
    private Week325 week325;

    @BeforeEach
    void setUp() {
        week325 = new Week325();
    }

    @Test
    void closetTarget() {
        String[] words = new String[]{"hello","i","am","leetcode","hello"};
        String target = "hello";
        int startIndex = 1;
        System.out.println(week325.closetTarget(words, target, startIndex));
    }
}