package graph;

import java.util.Arrays;

/**
 * LeetCode #743 (Medium)
 * @author binqibang
 * @date 2022/12/8
 */
public class NetworkDelayTime {
    /**
     * Dijkstra 算法
     * @TimeComplexity O(n^2)
     * @SpaceComplexity O(n^2)
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        // 无穷大特值，满足 INF + INF 不溢出
        final int INF = Integer.MAX_VALUE / 2;
        // 初始化邻接矩阵
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int[] t : times) {
            // 将节点编号 -1，使其位于 [0, n-1]
            int u = t[0] - 1, v = t[1] - 1, w = t[2];
            graph[u][v] = w;
        }
        // 初始化最短路径数组，`起点`到自身路径长度初始化为 0，其余为无穷
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        // flag[i] == true 表示`起点`到`顶点i`的最短路径已成功获取
        boolean[] flag = new boolean[n];
        for (int i = 1; i < n; i++) {
            // 在未获取最短路径的顶点中，找到离`起点`最近的顶点 u
            int u = 0, min = INF;
            for (int v = 0; v < n; v++) {
                if (!flag[v] && dist[v] < min) {
                    min = dist[v];
                    u = v;
                }
            }
            // 标记`顶点u`为已经获取到最短路径
            flag[u] = true;
            // 基于`u`修正最短路径
            for (int v = 0; v < n; v++) {
                dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
