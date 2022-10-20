package list;

/**
 * Node definition for singly-linked list.
 * @author binqibang
 */
public class ListNode {
   int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
