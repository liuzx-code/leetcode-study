
package leetcode.algorithm.binarytree;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree_297 {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        String SEP = ",";
        String NULL = "#";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        // 辅助函数，将二叉树存入 StringBuilder
        void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            // *****前序遍历位置*****
            sb.append(root.val).append(SEP);
            // *********************
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            // 将字符串转化成列表
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        // 辅助函数，通过 nodes 列表构造二叉树
        TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;
            // *****前序遍历位置*****
            // 列表最左侧就是根节点
            String first = nodes.removeFirst();
            if (first.equals(NULL)) return null;
            TreeNode root = new TreeNode(Integer.parseInt(first));
            // *********************
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }

    }
    
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree_297().new Codec();
        // put your test code here
        
    }
}