package list;

import org.junit.jupiter.api.Test;

class ReverseListIITest {

    @Test
    void reverseBetween() {
        ReverseListII rl = new ReverseListII();
        int[] nums = new int[] {1, 2, 3, 4, 5};
        var head = ListUtil.createList(nums);
        ListUtil.printList(rl.reverseBetween(head, 2, 4));
    }
}