package tree.bt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NextNodeTest {
    private NextNode nextNode;
    private BTLinkNode root, n1, n2, n3, n4, n5;

    @BeforeEach
    void setUp() {
        nextNode = new NextNode();
        root = new BTLinkNode(1);
        n1 = new BTLinkNode(2, root);
        n2 = new BTLinkNode(3, root);
        n3 = new BTLinkNode(4, n1);
        n4 = new BTLinkNode(5, n1);
        n5 = new BTLinkNode(6, n2);
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        root.left = n1;
        root.right = n2;
    }

    @Test
    void getNext() {
        var next = nextNode.getNext(n3);
        System.out.println(next.val);
    }
}