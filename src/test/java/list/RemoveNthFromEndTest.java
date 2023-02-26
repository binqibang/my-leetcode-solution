package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveNthFromEndTest {
    private RemoveNthFromEnd re;
    private ListNode head;

    @BeforeEach
    void setup() {
        re = new RemoveNthFromEnd();
        head = ListUtil.createList(new int[] {0, 1, 2, 3});
    }

    @Test
    void removeNthFromEnd() {
        ListUtil.printList(re.removeNthFromEnd1(head, 5));
    }

    @Test
    void kthFromEnd() {
        System.out.println(re.kthFromEnd(head, 4));
    }
}