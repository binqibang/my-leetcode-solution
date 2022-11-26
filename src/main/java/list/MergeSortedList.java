package list;

/**
 * LeetCode #21 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/9/6
 */
public class MergeSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // list1 为空，直接返回 list2
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(), prev = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return head.next;
    }

}
