package weekly;

import java.util.*;

/**
 * LeetCode Biweekly-Contest-93
 * @author binqibang
 * @date 2022/12/4
 */
public class BiWeek93 {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String str : strs) {
            boolean isDigit = true;
            int curr = 0;
            for (char ch : str.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    isDigit = false;
                    break;
                }
                curr = curr * 10 + ch - '0';
            }
            if (!isDigit) {
                curr = str.length();
            }
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (var edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int u = 0; u < n; u++) {
            List<Integer> neighs = adj.get(u);
            // 邻居按照节点值排序
            neighs.sort((a, b) -> vals[b] - vals[a]);
            // 无邻居星图
            int curSum = vals[u];
            maxSum = Math.max(maxSum, curSum);
            // 每连接一个邻居，看是否是最大值
            for(int v = 0; v < Math.min(k, neighs.size()); v++){
                curSum += vals[neighs.get(v)];
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }

    public int maxJump(int[] stones) {
        int ans = stones[1] - stones[0];
        for (int i = 2; i < stones.length; i++) {
            ans = Math.max(ans, stones[i] - stones[i-2]);
        }
        return ans;
    }
}
