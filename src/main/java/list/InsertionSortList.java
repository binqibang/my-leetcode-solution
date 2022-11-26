package list;

/**
 * LeetCode #147 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/24
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        // 在头结点前添加辅助结点，便于在头节点前插入
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 维护 lastSorted 为已排序最后结点
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = curr;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                // lastSorted 指向下一个待排序结点
                lastSorted.next = curr.next;
                // 插入 curr
                curr.next = prev.next;
                prev.next = curr;
            }
            // 更新待插入结点
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
