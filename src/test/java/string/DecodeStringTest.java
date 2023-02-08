package string;

import org.junit.jupiter.api.Test;

class DecodeStringTest {

    @Test
    void decodeString() {
        DecodeString ds = new DecodeString();
        String s = "3[a2[c]]";
        ds.decodeString(s);
    }
}