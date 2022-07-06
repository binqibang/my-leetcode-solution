package list;

/**
 * LeetCode #206 (Easy)
 * @author binqibang
 * @date 2022/7/6
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = curr.next;
        head.next = null;
        while (next != null) {
            ListNode backup = next.next;
            next.next = curr;
            curr = next;
            next = backup;
        }
        return curr;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5, null);
        node.next = node1;
        node1.next = node2;
        var head = reverseList(node);
    }
}
