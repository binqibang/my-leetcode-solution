package weekly;

import tree.bt.BTNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Weekly-Contest-319
 * @author binqibang
 * @date 2022/11/20
 */
public class Week320 {
    /**
     * #6241
     * @TimeComplexity O(n^3)
     * @param nums  0-indexed array of positive integers.
     * @return the number of triplets (i, j, k) where 0 <= i < j < k < nums.length
     *         nums[i], nums[j], and nums[k] are pairwise distinct.
     */
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] != nums[j]) && (nums[i] != nums[k])
                            && (nums[j] != nums[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * #6242
     * @param root of a binary search tree.
     * @param queries of size n consisting of positive integers.
     * @return 2D array answer of size n where answer[i] = [min_i, max_i]:
     *         min_i is the largest value that is smaller than or equal to queries[i],
     *         max_i is the smallest value that is greater than or equal to queries[i],
     *         If a such value does not exist, add -1 instead.
     * @TimeComplexity O(n^2)
     */
    public List<List<Integer>> closestNodes(BTNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int query : queries) {
            BTNode node = root;
            int min = -1, max = -1;
            while (node != null) {
                if (query <= node.getVal()) {
                    max = node.getVal();
                    node = node.getLeft();
                } else {
                    min = node.getVal();
                    node = node.getRight();
                }
            }
            if (query == max) {
                ans.add(List.of(query, query));
            } else {
                ans.add(List.of(min <= query ? min : -1, max >= query ? max : -1));
            }
        }
        return ans;
    }

    List<List<Integer>> edges;
    long ans = 0;

    /**
     * #6243
     * @param roads roads[i] = [ai, bi] denotes that there exists a bidirectional
     *              road connecting cities a_i and b_i.
     * @param seats the number of seats in each car.
     * @return minimum number of liters of fuel to reach the capital city.
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n^2)
     */
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        dfs(0, -1, seats);
        return ans;
    }

    private int dfs(int u, int parent, int seats) {
        int size = 1;
        for (int v : edges.get(u)) {
            if (v != parent) {
                // 统计 u -> v 这条边贡献
                size += dfs(v, u, seats);
            }
        }
        if (u > 0) {
            // 相当于 size / seats 向上取整
            ans += size / seats + (size % seats == 0 ? 0 : 1);
        }
        return size;
    }
}
