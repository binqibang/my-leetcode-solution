package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuildArrayFromStackTest {
    private BuildArrayFromStack ba;

    @BeforeEach
    void setUp() {
        ba = new BuildArrayFromStack();
    }

    @Test
    void buildArray() {
        int[] target = new int[] {1, 5};
        int n = 5;
        System.out.println(ba.buildArray(target, n));
    }
}