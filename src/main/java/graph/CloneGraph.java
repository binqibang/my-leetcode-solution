package graph;

import java.util.*;

/**
 * LeetCode #133 (Medium)
 * @author binqibang
 * @date 2022/12/6
 */
public class CloneGraph {
    private final Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node.val, clone);
        for (Node neighbor : node.neighbors) {
            if (!visited.containsKey(neighbor.val)) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }
        return clone;
    }

    public Node cloneGraph1(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> visited = new HashMap<>();
        visited.put(node.val, new Node(node.val, new ArrayList<>()));

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node u = queue.poll();
            for (Node v : u.neighbors) {
                if (!visited.containsKey(v.val)) {
                    visited.put(v.val, new Node(v.val, new ArrayList<>()));
                    queue.offer(v);
                }
                visited.get(u.val).neighbors.add(visited.get(v.val));
            }
        }

        return visited.get(node.val);
    }
}
