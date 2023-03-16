package list;

import org.junit.jupiter.api.Test;

class MergekKSortedListsTest {

    @Test
    void mergeKLists1() {
        ListNode l1 = ListUtil.createList(new int[] {1, 2, 3, 4});
        ListNode l2 = ListUtil.createList(new int[] {2, 6, 9});
        ListNode l3 = ListUtil.createList(new int[] {1, 3, 4, 8});
        ListNode l4 = ListUtil.createList(new int[] {5, 7, 8, 10});
        ListNode[] lists = new ListNode[] {l1, l2, l3, l4};
        MergeKSortedLists mkl = new MergeKSortedLists();
        mkl.mergeKLists1(lists);
    }
}