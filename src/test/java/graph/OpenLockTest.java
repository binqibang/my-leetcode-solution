package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpenLockTest {
    private OpenLock ol;

    @BeforeEach
    void setUp() {
        ol = new OpenLock();
    }

    @Test
    void openLock() {
        String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(ol.openLock(deadends, target));
    }

    @Test
    void getNextStatuses() {
        String cur = "0021";
        System.out.println(ol.getNextCodes(cur));
    }
}