package weekly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BiWeek94Test {

    private BiWeek94 biWeek94;

    @BeforeEach
    void setUp() {
        biWeek94 = new BiWeek94();
    }

    @Test
    void captureForts() {
        int[] forts = new int[] {0,0,1,-1};
        biWeek94.captureForts(forts);
    }
}