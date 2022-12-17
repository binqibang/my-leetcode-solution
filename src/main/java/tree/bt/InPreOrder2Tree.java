package tree.bt;

/**
 * LeetCode #105 (Medium); HOT 100
 * @author binqibang
 * @date 2022/12/16
 */
public class InPreOrder2Tree {
    /**
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n)
     */
    public BTNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private BTNode build(int[] preorder, int pStart, int pEnd, int[] inorder,
                         int iStart, int iEnd) {
        // `start`指向数组首元素，`end`指向数组末尾元素后一个位置
        if (pStart == pEnd) {
            return null;
        }
        // 先序遍历首先访问根节点
        int rootVal = preorder[pStart];
        BTNode root = new BTNode(rootVal);
        // 中序遍历序列中找到根节点
        int rootIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }
        int leftNum = rootIdx - iStart;
        // 递归构造左、右子树
        root.left = build(preorder, pStart + 1, pStart + leftNum + 1,
                inorder, iStart, rootIdx);
        root.right = build(preorder, pStart + leftNum + 1, pEnd,
                inorder, rootIdx + 1, iEnd);
        return root;
    }
}
