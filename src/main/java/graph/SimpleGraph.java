package graph;

import java.util.*;

public class SimpleGraph {
    /**
     * 邻接表，这里简便起见假定结点未携带数据，否则应构造图结点类
     */
    List<List<Integer>> adjacencyList;
    boolean[] visited;
    int numOfVertexs;

    /**
     * 创建有向图
     * @param n 图结点数
     * @param edges 边矩阵
     */
    public SimpleGraph(int n, int[][] edges) {
        numOfVertexs = n;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (var edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        visited = new boolean[n];
    }


    /**
     * 图的深度优先遍历
     */
    public void dfs(int root) {
        visited[root] = true;
        System.out.print(root + " ");
        for (int v : adjacencyList.get(root)) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    /**
     * 图的广度优先遍历
     */
    public void bfs(int root) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        visited[root] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v : adjacencyList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    /**
     * 返回从 start 起始到其他节点的最短路径数组
     */
    public int[] shortestPath(int start) {
        int[] dis = new int[numOfVertexs];
        Arrays.fill(dis, -1);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start, 0});
        visited[start] = true;
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            int u = curr[0], len = curr[1];
            if (dis[u] == -1) {
                dis[u] = len;
            }
            for (int v : adjacencyList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(new int[] {v, len + 1});
                }
            }
        }
        return dis;
    }

    public void clear() {
        Arrays.fill(visited, false);
    }
}
