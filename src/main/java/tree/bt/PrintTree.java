package tree.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #655 (Medium)
 * @author binqibang
 * @date 2022/8/22
 */
public class PrintTree {
    public List<List<String>> printTree(BTNode root) {
        int height = getHeight(root);
        String[][] matrix = new String[height][(1 << height) - 1];
        for (String[] row : matrix) {
            Arrays.fill(row, "");
        }
        fill(matrix, root, 0, 0, matrix[0].length);
        List<List<String>> res = new ArrayList<>();
        for (String[] row : matrix) {
            res.add(Arrays.asList(row));
        }
        return res;
    }

    private void fill(String[][] matrix, BTNode root, int level, int l, int r) {
        if (root == null) {
            return;
        }
        matrix[level][(l + r) / 2] = "" + root.val;
        fill(matrix, root.left, level + 1, l, (l + r) / 2);
        fill(matrix, root.right, level + 1, (l + r + 1) / 2, r);
    }

    private int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
