package leetcode.algorithm.binarytree;

import leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145.二叉树的后序遍历（左-右-根）
 */
public class BinaryTreePostorderTraversal_145 {

    class Solution {
        /**
         * 递归实现
         */
        public List<Integer> postorderTraversal1(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            res.addAll(postorderTraversal1(root.left));
            res.addAll(postorderTraversal1(root.right));
            res.add(root.val);
            return res;
        }
        /**
         * 栈实现
         */
        public List<Integer> postorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode lastVisited = null; // 标记最后访问的节点
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode peekNode = stack.peek();
                // 如果右子节点为空或者已经被访问过
                if (peekNode.right == null || peekNode.right == lastVisited) {
                    res.add(peekNode.val);
                    lastVisited = stack.pop();
                } else {
                    root = peekNode.right;
                }
            }

            return res;
        }
    }
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal_145().new Solution();
        // put your test code here
        
    }
}