package graph;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SimpleGraphTest {
    private SimpleGraph simpleGraph;

    @BeforeEach
    void setUp() {
        int[][] edges = new int[][] {{0,1}, {0,2}, {0,3}, {1,3}, {2,4}, {3,4}};
        int n = 5;
        simpleGraph = new SimpleGraph(n, edges);
    }

    @Test
    void dfs() {
        simpleGraph.dfs(0);
        simpleGraph.clear();
    }

    @Test
    void bfs() {
        simpleGraph.bfs(0);
    }

    @Test
    void shortestPath() {
        var dis = simpleGraph.shortestPath(1);
        System.out.println(Arrays.toString(dis));
    }

    @AfterEach
    void clear() {
        simpleGraph.clear();
    }
}