package list;

import org.junit.jupiter.api.Test;

class ReorderListTest {

    @Test
    void reorderList() {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        int[] nums1 = new int[] {1, 2, 3, 4, 5, 6};
        ReorderList rl = new ReorderList();
        var head1 = ListUtil.createList(nums);
        var head2 = ListUtil.createList(nums1);
        rl.reorderList(head1);
        ListUtil.printList(head1);
    }
}