package tree.bt;

/**
 * LeetCode #538 (Medium); HOT 100
 * @author binqibang
 * @date 2023/2/23
 */
public class BST2GST {
    int sum = 0;
    public BTNode convertBST(BTNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
