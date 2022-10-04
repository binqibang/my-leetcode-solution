package list;

/**
 * LeetCode #141 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/10/4
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        // list has no node or only one node
        if (head == null || head.next == null) {
            return false;
        }
        // slow and fast pointer
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // slow pointer run one step, while fast run two steps
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
