package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode #207 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/9/5
 */
public class CourseSchedule {
    /** [n, *] 邻接表表示有向边 */
    List<List<Integer>> edges;
    /** 入度数组 */
    int[] indegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indegree = new int[numCourses];

        // 对于先修关系 [a,b]，增加一条 b->a 的边，且 a 入度加一
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        // 队列记录当前入度为 0 的顶点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            // 当前入度为 0 的顶点
            int u = queue.poll();
            // 去掉从 u 出发的所有有向边
            for (int v : edges.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}
