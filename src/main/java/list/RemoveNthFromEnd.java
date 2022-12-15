package list;

/**
 * LeetCode #19 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/15
 */
public class RemoveNthFromEnd {
    /**
     * 解法一：计算链表长度
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 获得链表长度
        int length = 0;
        ListNode iter = head;
        while (iter != null) {
            length++;
            iter = iter.next;
        }
        // 哑节点指向链表头，删除节点时更方便
        ListNode dummy = new ListNode(-1, head);
        iter = dummy;
        // 倒数第`n`个节点相当于顺数第`length-n+1`个
        // 但删除时需要找到其前序节点
        for (int i = 1; i < length - n + 1; i++) {
            iter = iter.next;
        }
        // 删除节点
        iter.next = iter.next.next;
        return dummy.next;
    }

    /**
     * 解法二：快慢指针
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = dummy;
        // 让｀first`指针先走`n`步
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        // `second`开始走
        ListNode second = dummy;
        // 当`first`走到末尾时，`second`恰好走到倒数第`n`个节点处
        // 但删除时为了方便，需要找到其前序节点
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
