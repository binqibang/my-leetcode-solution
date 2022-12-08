package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortestPath {
    private final int INF = Integer.MAX_VALUE / 2;

    /**
     * Floyd 算法
     * @param n 图节点数
     * @param adj 邻接矩阵
     * @return 最短路径长度矩阵 dist, 最短路径矩阵 path
     */
    public List<int[][]> floyd(int n, int[][] adj) {
        int[][] dist = adj;
        int[][] path = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(path[i], -1);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        return List.of(dist, path);
    }

    public List<Integer> findPathFloyd(int[][] path, int u, int v) {
        List<Integer> order = new ArrayList<>();
        findPathFloyd(path, u, v, order);
        return order;
    }

    private void findPathFloyd(int[][] path, int u, int v, List<Integer> order) {
        if (path[u][v] == -1) {
            order.add(u);
        } else {
            findPathFloyd(path, u, path[u][v], order);
            findPathFloyd(path, path[u][v], v, order);
        }
    }

    public List<int[]> dijkstra(int n, int[][] adj, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        int[] path = new int[n];
        Arrays.fill(path, -1);
        boolean[] flag = new boolean[n];
        for (int i = 1; i < n; i++) {
            int u = 0, min = INF;
            for (int v = 0; v < n; v++) {
                if (!flag[v] && dist[v] < min) {
                    min = dist[v];
                    u = v;
                }
            }
            flag[u] = true;
            for (int v = 0; v < n; v++) {
                if (dist[u] + adj[u][v] < dist[v]) {
                    dist[v] = dist[u] + adj[u][v];
                    path[v] = u;
                }
            }
        }
        return List.of(dist, path);
    }

    public List<Integer> findPathDijkstra(int[] path, int end) {
        List<Integer> order = new ArrayList<>();
        int idx = end;
        while (path[idx] != -1) {
            order.add(idx);
            idx = path[idx];
        }
        order.add(idx);
        Collections.reverse(order);
        return order;
    }
}
