package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ShortestPathTest {
    private ShortestPath sp;
    private int[][] graph;
    private int n;

    @BeforeEach
    void setUp() {
        final int INF = Integer.MAX_VALUE / 2;
        sp = new ShortestPath();
        graph = new int[][]{
            {0  , 2  , INF, 6},
            {2  , 0  , 3  , 2},
            {INF, 3  , 0  , 2},
            {6  , 2  , 2  , 0}
        };
        n = 4;
    }

    @Test
    void floyd() {
        var ans = sp.floyd(n, graph);
        int[][] d = ans.get(0), p = ans.get(1);
        for (int[] arr : d) {
            System.out.println(Arrays.toString(arr));
        }
        for (int[] arr : p) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(sp.findPathFloyd(p, 0, 2));
    }

    @Test
    void dijkstra() {
        var ans = sp.dijkstra(n, graph, 0);
        int[] d = ans.get(0), p = ans.get(1);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(p));
        System.out.println(sp.findPathDijkstra(p, 2));
    }
}