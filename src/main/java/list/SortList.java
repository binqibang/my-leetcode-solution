package list;

import static list.MergeSortedList.mergeTwoLists;

/**
 * LeetCode #148 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/11/25
 */
public class SortList {

    /**
     * 自顶向下归并
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(logn)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针寻找链表中间分界
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 后半段链表头节点
        ListNode head1 = slow.next;
        // 将原始链表从边界处分割开
        slow.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(head1);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode prev = new ListNode(), curr = prev;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 != null ? list1 : list2;
        return prev.next;
    }


    /**
     * 自底向上归并
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(1)
     */
    public ListNode sortList1(ListNode head) {
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
                prev.next = mergeTwoLists(head1, head2);
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
