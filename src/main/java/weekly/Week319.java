package weekly;

import tree.bt.BTNode;

import java.util.*;

/**
 * LeetCode weekly-contest-319
 * @author binqibang
 * @date 2022/11/13
 */
public class Week319 {

    /**
     * #2 滑动窗口 + 剪枝
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(1)
     * @return the number of subarrays of nums where the least common multiple
     *         of the subarray's elements is k
     */
    public int subarrayLCM(int[] nums, int k) {
        int count = 0, n = nums.length;
        int left, right;

        for (left = 0; left < n; left++) {
            if (k % nums[left] != 0) {
                continue;
            }
            int lcm = nums[left];
            for (right = left; right < n; right++) {
                if (k % nums[right] != 0) {
                    break;
                }
                lcm = getLCM(lcm, nums[right]);
                if (lcm == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    /**
     * #3 层序遍历 + 置换环
     * @param root a binary tree with unique values.
     * @return the minimum number of operations needed to make the
     *         values at each level sorted in a strictly increasing order.
     * @TimeComplexity O(nlogn)
     * @SpaceComplexity O(n)
     */
    public int minimumOperations(BTNode root) {
        int ans = 0;
        Queue<BTNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int[] arr = new int[n];
            // get this level's nodes
            for (int i = 0; i < n; i++) {
                BTNode node = queue.poll();
                arr[i] = node.getVal();
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            // circle count
            ans += minSwaps(arr);
        }
        return ans;
    }

    /**
     * @return the minimum number of swap operations needed to make the values at nums
     *         sorted in a strictly increasing order.
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n)
     */
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        boolean[] flag = new boolean[n];
        Arrays.sort(nums);
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.put(nums[i], i);
        }
        int loop = 0;
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                int j = i;
                while (!flag[j]) {
                    int idx = indices.get(copy[j]);
                    flag[j] = true;
                    j = idx;
                }
                loop++;
            }
        }
        return n - loop;
    }

}
