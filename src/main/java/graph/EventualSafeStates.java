package graph;

import java.util.*;

/**
 * LeetCode #802 (Medium)
 * @author binqibang
 * @date 2022/12/7
 */
public class EventualSafeStates {
    /**
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(n^2)
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 存储指向节点的边
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        // 出度数组
        int[] outdegree = new int[n];
        for (int u = 0; u < n; u++) {
            outdegree[u] += graph[u].length;
            for (int v : graph[u]) {
                adj.get(v).add(u);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            ans.add(v);
            for (int u : adj.get(v)) {
                outdegree[u]--;
                if (outdegree[u] == 0) {
                    queue.offer(u);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
