
package leetcode.algorithm.binarytree;

import leetcode.editor.common.*;

/**
 * 124 . 二叉树中的最大路径和
 */
public class BinaryTreeMaximumPathSum_124 {

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
        // 用于保存最大路径和的结果
        private int maxSum;

        /**
         * 124 . 二叉树中的最大路径和
         */
        public int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            gain(root);
            return maxSum;
        }

        // 递归计算每个节点的最大路径贡献值
        private int gain(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左右子树的最大路径贡献值
            int leftGain = Math.max(gain(node.left), 0); // 忽略负数贡献
            int rightGain = Math.max(gain(node.right), 0);

            // 当前节点作为最高点时的最大路径和
            int currentPathSum = node.val + leftGain + rightGain;

            // 更新全局最大路径和
            maxSum = Math.max(maxSum, currentPathSum);

            // 返回当前节点向上层能贡献的最大路径值
            return node.val + Math.max(leftGain, rightGain);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum_124().new Solution();
        // put your test code here
        
    }
}