package weekly;

import list.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode Weekly-Contest-321
 * @author binqibang
 * @date 2022/11/27
 */
public class Week321 {
    /**
     * #6245
     * 求出等差数列和，一次遍历
     * @param n a positive integer.
     * @return  the pivot integer x where 1 + 2 + ... + x = x + ... + n.
     * @TimeComplexity O(n)
     */
    public int pivotInteger(int n) {
        int pivot = -1;
        int sum = n * (n + 1) / 2;
        int leftSum = 0;
        for (int i = 1; i <= n; i++) {
            leftSum += i;
            if (leftSum * 2 - i == sum) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    /**
     * #6246
     * t 变成 s 子序列至少需要 s 包含 t 所有字符，双指针遍历，遇到字符相等则 t 指针向前
     * @return the minimum number of characters that need to be appended
     *         to the end of s so that t becomes a subsequence of s.
     * @TimeComplexity O(n)
     */
    public int appendCharacters(String s, String t) {
        int tIdx = 0;
        for (int sIdx = 0; sIdx < s.length(); sIdx++) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                tIdx++;
                // t 遍历完且 s 含有 t 所有字符
                if (tIdx == s.length()) {
                    return 0;
                }
            }
        }
        return t.length() - tIdx;
    }

    /**
     * #6247
     * 单调栈
     * @param head  of a linked list.
     * @return Remove every node which has a node with a strictly greater
     *         value anywhere to the right side of it, then return the head.
     * @TimeComplexity O(n)
     */
    public ListNode removeNodes(ListNode head) {
        ListNode dummyHead = new ListNode((int) 1e6);
        Stack<ListNode> stack = new Stack<>();
        stack.push(dummyHead);
        while (head != null) {
            // 当前结点值大于栈顶元素，清空栈中比其小的结点，而后将栈顶结点指向当前结点，再入栈
            while (head.getVal() > stack.peek().getVal()) {
                stack.pop();
            }
            stack.peek().setNext(head);
            stack.push(head);
            head = head.getNext();
        }
        return dummyHead.getNext();
    }

    public int countSubarrays(int[] nums, int k) {
        // pos 即 k 的下标
        int pos = 0, n = nums.length;
        while (nums[pos] != k) {
            pos++;
        }
        int ans = 0;
        // 记录子数组 nums[i, pos-1] 中大于 k 和小于 k 的数量，小于 k 就 -1，大于 k 就 +1
        Map<Integer, Integer> leftCount = new HashMap<>();
        // nums[pos] = k
        leftCount.put(0, 1);
        for (int i = pos - 1, sum = 0; i >= 0; i--) {
            sum += nums[i] > k ? 1 : -1;
            // 等价于 leftCount[sum]++
            leftCount.put(sum, leftCount.getOrDefault(sum, 0) + 1);
        }
        ans += leftCount.get(0) + leftCount.getOrDefault(1, 0);
        // 记录子数组 nums[pos + 1, i] 中大于 k 和小于 k 的数量，
        // 若 leftCount 某值 x 满足 sum + x == 0 or 1
        for (int i = pos + 1, sum = 0; i < n; i++) {
            sum += nums[i] > k ? 1 : -1;
            ans += leftCount.getOrDefault(-1 * sum, 0) +
                    leftCount.getOrDefault(1 - sum, 0);
        }
        return ans;
    }
}
