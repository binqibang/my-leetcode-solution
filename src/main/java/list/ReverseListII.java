package list;

/**
 * LeetCode #92 (Medium)
 * @author binqibang
 * @date 2023/2/22
 */
public class ReverseListII {
    /**
     * 未考虑参数是否合法
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        // prev 指向左边界上一个节点
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode rNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rNode = rNode.next;
        }
        ListNode lNode = prev.next;
        // next 指向右边界下一个节点
        ListNode next = rNode.next;
        // 断开连接
        prev.next = null;
        rNode.next = null;
        // 反转切割出的子链表
        reverseList(lNode);
        // 重新连接
        prev.next = rNode;
        lNode.next = next;
        return dummy.next;
    }

    private void reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (head == null || left <= 0 || right <= 0 || left >= right) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, curr = head;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            curr = curr.next;
            if (curr == null) {
                return head;
            }
        }

        ListNode lNode = prev, rNode = curr;

        ListNode next;
        for (int i = left; i <= right ; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr == null) {
                break;
            }
        }

        lNode.next = prev;
        rNode.next = curr;

        return dummy.next;
    }
}
