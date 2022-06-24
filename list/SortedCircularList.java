package list;

/**
 * LeetCode #708 (Medium)
 * @author binqibang
 * @date 2022/6/18
 */
public class SortedCircularList {
    /**
     * 分类讨论，插入值在`head`前或后<br>
     * 特殊情况：空结点；单结点；所有元素同一值
     * @param head
     * @param insertVal
     * @return
     */
    public static Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node idx = head;
        if (head.val <= insertVal) {
            // 找到合适位置或最大值结点
            // idx.next != head 条件防止在全是同一值的结点发生无限循环
            while (idx.next.val < insertVal && (idx.next.val >= idx.val) && (idx.next != head)) {
                idx = idx.next;
            }
        } else {
            idx = head;
            // 找到最大值结点
            while (idx.next.val >= idx.val && (idx.next != head)) {
                idx = idx.next;
            }
            // 找到插入位置
            while (idx.next.val < insertVal) {
                idx = idx.next;
            }
        }
        node.next = idx.next;
        idx.next = node;
        return head;
    }

    public static void main(String[] args) {
        Node init = null;
        Node head = insert(init, 5);
        head = insert(head,3);
        head = insert(head,3);
        head = insert(head, 0);

    }
}
