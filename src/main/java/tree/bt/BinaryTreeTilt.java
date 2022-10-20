package tree.bt;

/**
 * LeetCode #563 (Easy)
 * @author binqibang
 * @date 2022/8/3
 */
public class BinaryTreeTilt {
    /**
     * 此题是二叉树另一种典型问题，即在递归外加上一层全局处理，
     * 需要用全局变量记录结果，递归提供所需条件，如子树和等。
     */
    int tilt = 0;

    public int findTilt(BTNode root) {
        dfs(root);
        return tilt;
    }

    /**
     * dfs 处理子树和，再利用子树和计算坡度，加到全局答案变量中
     */
    public int dfs(BTNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = dfs(root.left);
        int sunRight = dfs(root.right);
        tilt += Math.abs(sumLeft - sunRight);
        return root.val + sumLeft + sunRight;
    }
}
