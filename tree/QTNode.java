package tree;

/**
 * Definition for a QuadTree node.
 */
public class QTNode {
    public boolean val;
    public boolean isLeaf;
    public QTNode topLeft;
    public QTNode topRight;
    public QTNode bottomLeft;
    public QTNode bottomRight;

    public QTNode() {
    }

    public QTNode(boolean val, boolean isLeaf, QTNode topLeft, QTNode topRight, QTNode bottomLeft, QTNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
