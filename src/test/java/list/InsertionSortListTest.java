package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertionSortListTest {
    private InsertionSortList isl;

    @BeforeEach
    void setUp() {
        isl = new InsertionSortList();
    }

    @Test
    void insertionSortList() {
        int[] values = new int[] {-1,5,3,4,0};
        var head = ListUtil.createList(values);
        var sorted = isl.insertionSortList(head);
    }
}