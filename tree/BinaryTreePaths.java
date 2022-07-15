package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode #257 (Easy)
 * @author binqibang
 * @date 2022/6/23
 */
public class BinaryTreePaths {

    /**
     * 非递归算法，用栈模拟先序遍历<br>
     * Time: O(n^2); Space: O(n^2)
     * @param root
     * @return all root-to-leaf paths in any order
     */
    public List<String> binaryTreePaths1(BTNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<BTNode> stack = new Stack<>();
        Stack<String> path = new Stack<>();
        stack.push(root);
        path.push(root.val + "");
        while (!stack.isEmpty()) {
            BTNode curr = stack.pop();
            String currPath = path.pop();
            if (curr.left == null && curr.right == null) {
                res.add(currPath);
            }
            if (curr.left != null) {
                stack.push(curr.left);
                path.push(currPath + "->" + curr.left.val);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                path.push(currPath + "->" + curr.right.val);
            }
        }
        return res;
    }

    private List<String> paths;

    /**
     * 递归算法，深度优先遍历
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(BTNode root) {
        paths = new ArrayList<>();
        dfs(root, "");
        return paths;
    }

    public void dfs(BTNode root, String path) {
        // 递归出口
        if (root == null) {
            return;
        }
        // `root`处理
        StringBuilder builder = new StringBuilder(path);
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(builder.toString());
        } else {
            builder.append("->");
            // 递归体
            dfs(root.left, builder.toString());
            dfs(root.right, builder.toString());
        }
    }
}
