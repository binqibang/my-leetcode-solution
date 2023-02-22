package list;

import org.junit.jupiter.api.Test;

class SortListTest {

    @Test
    void sortList() {
        SortList sl = new SortList();
        int[] values = new int[] {-1, 5, 3, 4, 0};
        var head = ListUtil.createList(values);
        ListUtil.printList(sl.sortList(head));
    }
}