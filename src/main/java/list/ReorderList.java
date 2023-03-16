package list;

/**
 * LeetCode #143 (Medium)
 * @author binqibang
 * @date 2023/2/22
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 找到链表中间节点
        ListNode mid = middleNode(head);
        // 将链表分成两半（奇数长链表前半段长度大1）
        ListNode l1 = head, l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public void mergeList(ListNode l1, ListNode l2) {
        ListNode next1, next2;
        while (l1 != null && l2 != null) {
            next1 = l1.next;
            next2 = l2.next;

            l1.next = l2;
            l1 = next1;

            l2.next = l1;
            l2 = next2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
