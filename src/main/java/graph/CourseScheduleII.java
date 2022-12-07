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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adadjacency list
        List<List<Integer>> adj = new ArrayList<>();
        // initialize adjacency list and indegree array
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int[numCourses];
        // for prerequisite [a,b]，add edge (b, a), and a's indegree plus 1
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        // use queue to store vertex which indegree is 0
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int idx = 0;
        // bfs
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[idx++] = u;
            // remove all edges from `u`
            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return idx == numCourses ? order : new int[] {};
    }
}
