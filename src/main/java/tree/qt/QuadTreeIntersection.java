package tree.qt;

/**
 * LeetCode #558 (Medium)
 * @author binqibang
 * @date 2022/7/15
 */
public class QuadTreeIntersection {
    /**
     * 这题题目翻译真的垃圾，全是捣乱，实际上就是结点属性`相与`
     * @return 两棵树每个结点 val,isLeaf 属性相与之后的根节点
     */
    public QTNode intersect(QTNode quadTree1, QTNode quadTree2) {
        // quadTree1 为叶节点，则`相与`后结果肯定为叶节点, 1 | x = 1
        if (quadTree1.isLeaf) {
            // quadTree1.val = 1, 1 | x = 1, 直接返回
            if (quadTree1.val) {
                return new QTNode(true, true, null, null, null, null);
            }
            // quadTree1.val = 0，0 | x = x，由 quadTree2 决定
            return quadTree2;
        }
        // quadTree2 为叶节点，算法同上
        if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                return new QTNode(true, true, null, null, null, null);
            }
            return quadTree1;
        }
        // 两者都不是叶子节点时，分别对两者的四个子节点递归
        QTNode topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        QTNode topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        QTNode bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        QTNode bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        // 四个子节点都是叶子结点并且值相同，合并为一个新叶节点
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new QTNode(topLeft.val, true, null, null, null, null);
        }
        // 否则返回非叶节点，val 任意
        return new QTNode(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
