package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #2049 (Medium)
 * @author binqibang
 * @date 2022/8/8
 */
public class CountHighestScoreNodes {

    long maxScore = 0;
    int count = 0;
    int n;
    List<List<Integer>> children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        // 找到所有子结点
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children.get(p).add(i);
            }
        }
        dfs(0);
        return count;
    }

    /**
     * 在 DFS 中计算以该结点为根的`分数`，并返回该结点子树`大小`
     * @param node 任一结点
     * @return 子树大小
     */
    public int dfs(int node) {
        long score = 1;
        // 统计子树结点数
        int sum = 1;
        for (int c : children.get(node)) {
            int t = dfs(c);
            score *= t;
            sum += t;
        }
        if (node != 0) {
            score *= n - sum;
        }
        if (score == maxScore) {
            count++;
        } else if (score > maxScore) {
            maxScore = score;
            count = 1;
        }
        return sum;
    }
}
