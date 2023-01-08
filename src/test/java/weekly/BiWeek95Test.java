package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BiWeek95Test {
    private BiWeek95 biWeek95;

    @BeforeEach
    void setUp() {
        biWeek95 = new BiWeek95();
    }

    @Test
    void categorizeBox() {
        biWeek95.categorizeBox(2909, 3968, 3272, 727);
    }

    @Test
    void testDataStream() {
        DataStream ds = new DataStream(4, 3);
        ds.consec(4);
        ds.consec(4);
        ds.consec(4);
        ds.consec(3);
    }
}