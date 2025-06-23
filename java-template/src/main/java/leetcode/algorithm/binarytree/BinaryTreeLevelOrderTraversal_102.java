
package leetcode.algorithm.binarytree;

import java.util.*;
import leetcode.editor.common.*;

public class BinaryTreeLevelOrderTraversal_102 {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        /**
         * 102 二叉树的层次遍历
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            // 如果根节点为空，直接返回一个空的ArrayList
            if (root == null) return new ArrayList<>();
            // 初始化结果列表，用于存储每一层的节点值
            List<List<Integer>> res = new ArrayList<>();

            // 使用队列辅助进行层次遍历
            Queue<TreeNode> queue = new LinkedList<>();
            // 将根节点加入队列开始遍历
            queue.offer(root);
            // 当队列不为空时，继续遍历
            while (!queue.isEmpty()) {
                // 当前层的节点数量
                int levelSize = queue.size();
                // 初始化当前层的节点值列表
                List<Integer> currentLevel = new ArrayList<>();

                // 遍历当前层的所有节点
                for (int i = 0; i < levelSize; i++) {
                    // 从队列中取出一个节点
                    TreeNode node = queue.poll();
                    // 将节点值添加到当前层的列表中
                    currentLevel.add(node.val);

                    // 如果当前节点有左子节点，将其加入队列
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    // 如果当前节点有右子节点，将其加入队列
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                // 将当前层的节点值列表添加到最终结果中
                res.add(currentLevel);
            }
            // 返回最终的层次遍历结果
            return res;
        }

        //leetcode submit region end(Prohibit modification and deletion)


        public static void main(String[] args) {
            Solution solution = new BinaryTreeLevelOrderTraversal_102().new Solution();
            // put your test code here

        }
    }
}