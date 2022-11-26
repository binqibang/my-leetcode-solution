package list;

/**
 * LeetCode #148 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/25
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        // 统计链表长度
        int len = 0;
        ListNode iter = head;
        while (iter != null) {
            len++;
            iter = iter.next;
        }
        // 头结点前引入辅助结点
        ListNode dummyHead = new ListNode(0, head);
        // 每次将链表拆分成若干个长度为 subLen 的子链表, 并按照每两个子链表一组进行合并
        for (int subLen = 1; subLen < len; subLen *= 2) {
            // curr 记录开始拆分链表的位置
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                // 链表1头结点在 curr 初始位置
                ListNode head1 = curr;
                // curr 走到 subLen 指定位置
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 链表2头结点在链表1尾部下一个位置
                ListNode head2 = curr.next;
                // 断开两个链表连接
                curr.next = null;
                // 再拆分出 subLen 长度链表
                curr = head2;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // next 用于记录拆分完两个链表的结束位置
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // 合并链表1、2
                prev.next = MergeSortedList.mergeTwoLists(head1, head2);
                //  将 prev 移动到 subLen*2 的位置后去
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return head;
    }
}
