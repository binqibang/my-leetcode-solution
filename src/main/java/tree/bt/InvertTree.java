package tree.bt;

/**
 * LeetCode #226 (Easy); HOT 100
 * @author binqibang
 * @date 2022/12/17
 */
public class InvertTree {
    /**
     * 解法一：后序遍历
     */
    public BTNode invertTree(BTNode root) {
        if (root == null) {
            return null;
        }
        BTNode left = invertTree(root.left);
        BTNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 解法二：前序遍历
     */
    public BTNode invertTree1(BTNode root) {
        if (root == null) {
            return null;
        }
        BTNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }
}
