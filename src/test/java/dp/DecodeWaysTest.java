package dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecodeWaysTest {
    private DecodeWays dw;

    @BeforeEach
    void setUp() {
        dw = new DecodeWays();
    }

    @Test
    void numDecodings() {
        String s = "1315";
        String s1 = "102345";
        System.out.println(dw.numDecodings(s1));
    }
}