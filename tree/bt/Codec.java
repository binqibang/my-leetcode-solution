package tree.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode #297 (Hard)
 * @author binqibang
 * @date 2022/9/2
 */
public class Codec {
    /** Encodes a tree to a single string.
     * @param root root node.
     * @return serialized string of given binary tree.
     */
    public String serialize(BTNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize(root.left) + ","  + serialize(root.right);
    }

    /** Decodes your encoded data to tree.
     * @param data serialized string of given binary tree.
     * @return original binary tree.
     */
    public BTNode deserialize(String data) {
        String[] arr = data.split(",");
        ArrayList<String> nodes = new ArrayList<>(Arrays.asList(arr));
        return rdeserialize(nodes);
    }

    private BTNode rdeserialize(List<String> nodes) {
        if ("null".equals(nodes.get(0))) {
            nodes.remove(0);
            return null;
        }
        BTNode node = new BTNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        node.left = rdeserialize(nodes);
        node.right = rdeserialize(nodes);
        return node;
    }
}
