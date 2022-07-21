package tree.bt;

public class BinaryTreePruning {
    public BTNode pruneTree(BTNode root) {
        // 边界条件1
        if (root == null) {
            return null;
        }
        // 需要对二叉树结构有调整或构造二叉树时，一般使用如下表达式；
        // 只需要读取二叉树信息时，一般只需要递归调用即可
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 满足条件最小解，即值为 0 的叶节点
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
