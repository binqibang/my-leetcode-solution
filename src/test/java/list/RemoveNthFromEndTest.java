package list;

import org.junit.jupiter.api.Test;

class RemoveNthFromEndTest {

    @Test
    void removeNthFromEnd() {
        RemoveNthFromEnd re = new RemoveNthFromEnd();
        ListNode head = ListUtil.createList(new int[] {0, 1, 2, 3});
        var ans = re.removeNthFromEnd1(head, 3);
        ListUtil.printList(ans);
    }
}