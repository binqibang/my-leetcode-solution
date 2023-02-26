package list;


/**
 * LeetCode #83 (Easy), #82 (Medium); CodeTop MeiTuan
 * @author binqibang
 * @date 2023/2/26
 */
public class RemoveSortedListDuplicates {
    /**
     * 对于重复节点，只留下一个
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                // 遇见重复元素，删除
                curr.next = curr.next.next;
            } else {
                // 否则指针向后移动
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * 对于重复节点，全部删除
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 当可能修改`head`时，最好增加哑节点
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                // 记录重复值，然后删除所有该值的节点
                int dupliVal = curr.next.val;
                while (curr.next != null && curr.next.val == dupliVal) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
