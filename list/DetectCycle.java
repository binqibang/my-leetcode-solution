package list;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode #141 (Easy); CodeTop MS
 * @author binqibang
 * @date 2022/10/4
 */
public class DetectCycle {
    /**
     * 使用集合存储访问过的结点 <br>
     * Time: O(n); Space: O(n)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> visited = new HashSet<>();
        ListNode iter = head;
        while (iter != null && !visited.contains(iter.next)) {
            visited.add(iter);
            iter = iter.next;
        }
        return iter == null? null : iter.next;
    }

    /**
     * When two pointer meet, fast one: a + n (b + c) + b = a + (n + 1) b + nc,
     * slow one: (a + b), then: a + (n + 1) b + nc = 2 (a + b),
     * a = c + (n - 1)(b + c)
     * @param head head of a linked list
     * @return the node where the cycle begins
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // when two pointer meet, let one pointer from head,
            // run when it meets slow pointer.
            if (fast == slow) {
                ListNode iter = head;
                while (iter != slow) {
                    iter = iter.next;
                    slow = slow.next;
                }
                return iter;
            }
        }
        return null;
    }
}
