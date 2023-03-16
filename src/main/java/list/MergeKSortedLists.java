package list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode #23 (Hard)
 * @author binqibang
 * @date 2023/3/16
 */
public class MergeKSortedLists {
    /**
     * 解法一：顺序遍历链表数组，不断合并
     * @param lists 升序链表数组
     * @return 合并后的链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (ListNode l : lists) {
            ans = mergeTwoLists(ans, l);
        }
        return ans;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    /**
     * 解法二：分治法，将 k 个链表配对并将同一对中的链表合并
     * @param lists 升序链表数组
     * @return 合并后的链表
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        ListNode lList = merge(lists, l, mid);
        ListNode rList = merge(lists, mid + 1, r);
        return mergeTwoLists(lList, rList);
    }

    /**
     * 解法三：使用堆合并
     * @param lists 升序链表数组
     * @return 合并后的链表
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (var list : lists) {
            heap.offer(list);
        }
        ListNode dummy = new ListNode(-1), prev = dummy;
        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            prev.next = curr;
            prev = prev.next;
            if (curr.next != null) {
                heap.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
