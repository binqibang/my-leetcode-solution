package tree.bt;

import org.junit.jupiter.api.Test;

class SymmetricTreeTest {
    @Test
    void isSymmetric() {
        SymmetricTree st = new SymmetricTree();
        int[] values = new int[] {1, 2 ,2, 3, 4, 4, 3};
        BTNode root = BTUtil.createBT(values);
        st.isSymmetric1(root);
    }
}