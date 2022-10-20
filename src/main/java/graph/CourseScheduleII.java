package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode #210 (Medium); CodeTop MS
 * @author binqibang
 * @date 2022/10/7
 */
public class CourseScheduleII {
    List<List<Integer>> edges = new ArrayList<>();
    int[] indegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        // initialize adjacency list and indegree array
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indegree = new int[numCourses];
        // for prerequisite [a,b]，add edge (b, a), and a's indegree plus 1
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        // use queue to store vertex which indegree is 0
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // bfs
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            // remove all edges from `u`
            for (int v : edges.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (order.size() == numCourses) {
            int[] res = new int[order.size()];
            for (int i = 0; i < order.size(); i++) {
                res[i] = order.get(i);
            }
            return res;
        } else {
            return new int[0];
        }
    }
}
