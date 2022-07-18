package tree.bt;

import java.util.*;

/**
 * LeetCode #508 (Medium)
 * @author binqibang
 * @date 2022/6/19
 */
public class MostFreqSubtreeSum {
    Map<Integer, Integer> count = new HashMap<>();
    int maxCount = 0;

    /**
     * 深度优先遍历，递归计算子树元素和，
     * 用哈希表记录 sum, count
     * @param root
     * @return sum of its left and right subtree
     */
    public int dfs(BTNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + dfs(root.left) + dfs(root.right);
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(count.get(sum), maxCount);
        return sum;
    }

    public int[] findFrequentTreeSum(BTNode root) {
        dfs(root);
        List<Integer> tmp = new ArrayList<>();
        for(var key : count.keySet()) {
            int value = count.get(key);
            if (value == maxCount) {
                tmp.add(key);
            }
        }
        int[] ans = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); ++i) {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}
