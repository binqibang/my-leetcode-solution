package list;

/**
 * Node definition for singly-linked list.
 * @author binqibang
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public int getVal() {
        return val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
