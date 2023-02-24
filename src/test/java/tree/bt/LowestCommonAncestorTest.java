package tree.bt;

import org.junit.jupiter.api.Test;

import static tree.bt.BTUtil.NULL;

class LowestCommonAncestorTest {

    @Test
    void lowestCommonAncestor() {
        int[] vals = new int[] {3, 5, 1, 6, 2, 0, 8, NULL, NULL, 7, 4, NULL, NULL, NULL, NULL};
        var root = BTUtil.createBT(vals);
        var p = root.left;
        var q = p.right.right;
        LowestCommonAncestor lca = new LowestCommonAncestor();
        lca.lowestCommonAncestor(root, p, q);
    }
}