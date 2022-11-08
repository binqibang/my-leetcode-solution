package tree.bt;

/**
 * CodeTop MS
 * @author binqibang
 * @date 2022/11/8
 */
public class NextNode {
    public BTLinkNode getNext(BTLinkNode node) {
        if (node == null) {
            return null;
        }
        BTLinkNode ans;
        // 该结点有右子树，则找到右子树最左结点
        if (node.right != null) {
            ans = node.right;
            while (ans.left != null) {
                ans = ans.left;
            }
            return ans;
        }
        ans = node;
        while (ans.next != null) {
            // 该结点是父节点左孩子，则其下一个节点即父结点
            if (ans.next.left == node) {
                return ans.next;
            }
            // 否则，沿父结点往上寻找直到满足上述情况或到根节点
            ans = ans.next;
        }
        return null;
    }
}
