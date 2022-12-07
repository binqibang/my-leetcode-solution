package graph;

import java.util.*;

/**
 * LeetCode #1129 (Medium)
 * @author binqibang
 * @date 2022/12/6
 */
public class ShortestAlternatingPaths {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        final int RED = 0, BLUE = 1;
        // 分别构建红、蓝色边的邻接表
        List<List<Integer>> redAdj = new ArrayList<>(), blueAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            redAdj.add(new ArrayList<>());
            blueAdj.add(new ArrayList<>());
        }
        for (var redEdge : redEdges) {
            redAdj.get(redEdge[0]).add(redEdge[1]);
        }
        for (var blueEdge : blueEdges) {
            blueAdj.get(blueEdge[0]).add(blueEdge[1]);
        }
        boolean[] redVisited = new boolean[n], blueVisited = new boolean[n];
        // BFS, <v, color, len>
        Queue<int[]> queue = new ArrayDeque<>();
        // 初始时两种颜色的边都可以走
        queue.add(new int[]{0, RED, 0}); redVisited[0] = true;
        queue.add(new int[]{0, BLUE, 0}); blueVisited[0] = true;
        // 初始化最短路径数组
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // BFS 求无权图最短路径算法
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            int u = curr[0], color = curr[1], len = curr[2];
            if (ans[u] == -1) {
                ans[u] = len;
            }
            if (color == RED) {
                for (int v : blueAdj.get(u)) {
                    if (!blueVisited[v]) {
                        blueVisited[v] = true;
                        queue.offer(new int[] {v, BLUE, len + 1});
                    }
                }
            } else if (color == BLUE) {
                for (int v : redAdj.get(u)) {
                    if (!redVisited[v]) {
                        redVisited[v] = true;
                        queue.offer(new int[] {v, RED, len + 1});
                    }
                }
            }
        }
        return ans;
    }
}
