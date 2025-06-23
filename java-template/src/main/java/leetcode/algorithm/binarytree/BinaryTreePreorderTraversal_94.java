package leetcode.algorithm.binarytree;


import leetcode.editor.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * 94 . 二叉树的中序遍历
 */
public class BinaryTreePreorderTraversal_94 {

    class Solution {
        /**
         * 方法一：递归
         */
        public List<Integer> inorderTraversal1(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            res.addAll(inorderTraversal1(root.left));
            res.add(root.val);
            res.addAll(inorderTraversal1(root.right));
            return res;
        }
        /**
         * 方法二：迭代
         */
        public List<Integer> inorderTraversal2(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }
    }
}
