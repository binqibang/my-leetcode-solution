package dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumSquaresTest {
    private NumSquares numSquares;

    @BeforeEach
    void setUp() {
        numSquares = new NumSquares();
    }

    @Test
    void numSquares() {
        numSquares.numSquares(12);
    }
}