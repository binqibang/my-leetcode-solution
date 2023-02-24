package tree.bt;

import org.junit.jupiter.api.Test;

import static tree.bt.BTUtil.NULL;

class BST2GSTest {

    @Test
    void convertBST() {
        int[] vals = new int[] {4,1,6,0,2,5,7,NULL,NULL,NULL,3,NULL,NULL,NULL,8};
        var root = BTUtil.createBT(vals);
        BST2GST b2g = new BST2GST();
        b2g.convertBST(root);
    }
}