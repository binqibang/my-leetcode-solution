package tree.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #114 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/16
 */
public class BT2List {
    /**
     * 存储前序遍历序列，然后遍历序列构建“单链表”
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n)
     */
    public void flatten(BTNode root) {
        if (root == null) {
            return;
        }
        List<BTNode> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        for (int i = 1; i < preorder.size(); i++) {
            BTNode prev = preorder.get(i-1), curr = preorder.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorderTraversal(BTNode root, List<BTNode> preorder) {
        if (root == null) {
            return;
        }
        preorder.add(root);
        preorderTraversal(root.left, preorder);
        preorderTraversal(root.right, preorder);
    }
}
