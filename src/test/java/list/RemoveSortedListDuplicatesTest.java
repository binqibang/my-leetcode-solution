package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveSortedListDuplicatesTest {
    private RemoveSortedListDuplicates rsld;
    private ListNode head;

    @BeforeEach
    void setup() {
        rsld = new RemoveSortedListDuplicates();
        int[] vals = new int[] {1, 2, 3, 3, 4, 4, 5};
        head = ListUtil.createList(vals);
    }

    @Test
    void deleteDuplicates() {
        ListUtil.printList(rsld.deleteDuplicates(head));
    }

    @Test
    void deleteDuplicates1() {
        ListUtil.printList(rsld.deleteDuplicates1(head));
    }
}