package weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode Weekly-Contest-322
 * @author binqibang
 * @date 2022/12/4
 */
public class Week322 {
    /**
     * #6253 注意末尾单词的下一个单词回到句首
     * @TimeComplexity O(n)
     */
    public boolean isCircularSentence(String sentence) {
        var words = sentence.split(" ");
        int n = words.length;
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            String prev = words[i];
            String next = i == n - 1 ? words[0] : words[i+1];
            if (prev.charAt(prev.length() - 1) != next.charAt(0)) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    /**
     * #6254 先排序再从两边向中间搜索
     * @TimeComplexity O(nlogn)
     */
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        long chemSum = 0;
        int skillSum = skill[0] + skill[n-1];
        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n-i-1] != skillSum) {
                return -1;
            }
            chemSum += (long) skill[i] * skill[n-i-1];
        }
        return chemSum;
    }

    /** 带权图邻接表, 如带权边 0 -(2)-> 1 表示为 [0, 1, 2] */
    List<List<int[]>> edges;
    boolean[] visited;

    /**
     * #6256 求结点 1 -> n 所有路径中最短边，实际上从 1 出发，深度遍历所有可达城市，找到最小的 distance
     * @TimeComplexity O(m+n)
     */
    public int minScore(int n, int[][] roads) {
        edges = new ArrayList<>();
        visited = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (var road : roads) {
            edges.get(road[0]).add(new int[]{road[1], road[2]});
            edges.get(road[1]).add(new int[]{road[0], road[2]});
        }
        return dfs(1);
    }
    private int dfs(int u) {
        int min = Integer.MAX_VALUE;
        visited[u] = true;
        for (var v : edges.get(u)) {
            min = Math.min(min, v[1]);
            if (!visited[v[0]]) {
                min = Math.min(min, dfs(v[0]));
            }
        }
        return min;
    }
}
