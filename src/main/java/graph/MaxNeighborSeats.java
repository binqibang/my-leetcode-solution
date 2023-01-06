package graph;

public class MaxNeighborSeats {
    public int maxNeighborSeats(int[][] seats) {
        int m = seats.length, n = seats[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == 0) {
                    ans = Math.max(ans, dfs(i, j, seats));
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] seats) {
        if (i < 0 || i >= seats.length || j < 0 || j >= seats[0].length) {
            return 0;
        }
        if (seats[i][j] != 0) {
            return 0;
        }
        // 标记访问过的位置
        seats[i][j] = 2;
        return 1 + dfs(i + 1, j, seats) + dfs(i - 1, j, seats)
                 + dfs(i, j + 1, seats) + dfs(i, j - 1, seats);
    }
}
