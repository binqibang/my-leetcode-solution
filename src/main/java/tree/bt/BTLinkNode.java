package tree.bt;

public class BTLinkNode {
    int val;
    BTLinkNode left;
    BTLinkNode right;
    BTLinkNode next;    // 指向父结点

    public BTLinkNode() {
    }

    public BTLinkNode(int val) {
        this.val = val;
    }

    public BTLinkNode(int val, BTLinkNode next) {
        this.val = val;
        this.next = next;
    }

    public BTLinkNode(int val, BTLinkNode left, BTLinkNode right, BTLinkNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
