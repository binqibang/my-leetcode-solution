package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelColumnTitleTest {
    private ExcelColumnTitle ec;

    @BeforeEach
    void setUp() {
        ec = new ExcelColumnTitle();
    }

    @Test
    void convertToTitle() {
        System.out.println(ec.convertToTitle(701));
    }
}