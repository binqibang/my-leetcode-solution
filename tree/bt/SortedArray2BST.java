package tree.bt;

import java.util.Arrays;

/**
 * LeetCode #108 (Easy)
 * @author binqibang
 * @date 2022/7/18
 */
public class SortedArray2BST {
    public static BTNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int n = nums.length;
        BTNode root = new BTNode(nums[n / 2]);
        // 为保持 BST 高度最小，需要从中间切分
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, n / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, n / 2 + 1, n));
        return root;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {-10,-3,0,5,9};
        BinaryTree bt = new BinaryTree();
        var root = sortedArrayToBST(nums);
        bt.printBinaryTree(root);
    }
}
