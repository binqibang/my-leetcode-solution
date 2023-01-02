package list;

import org.junit.jupiter.api.Test;

class AddTwoNumsTest {

    @Test
    void addTwoNumbers() {
        AddTwoNums atn = new AddTwoNums();
        int[] nums1 = new int[] {1, 2, 3, 4};
        int[] nums2 = new int[] {4, 5, 7};
        ListNode l1 = ListUtil.createList(nums1);
        ListNode l2 = ListUtil.createList(nums2);
        var ans = atn.addTwoNumbers(l1, l2);
        ListUtil.printList(ans);
    }
}