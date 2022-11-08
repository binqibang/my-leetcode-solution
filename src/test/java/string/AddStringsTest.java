package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddStringsTest {
    private AddStrings as;

    @BeforeEach
    void setUp() {
        as = new AddStrings();
    }

    @Test
    void addStrings() {
        String num1 = "123456789", num2 = "987654321";
        System.out.println(as.addStrings(num1, num2));
    }
}