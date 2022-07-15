package tree;

public class BTNode {
    int val;
    BTNode left;
    BTNode right;

    public BTNode() {
    }

    public BTNode(int val) {
        this.val = val;
    }

    public BTNode(int val, BTNode left, BTNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
