
package leetcode.algorithm.binarytree;

import java.util.*;
import leetcode.editor.common.*;

/**
 * 112. 路径总和
 */
public class PathSum_112 {

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
         * 112. 路径总和
         * @param root
         * @param targetSum
         * @return
         */
        public boolean hasPathSum(TreeNode root, int targetSum) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> sumStack = new Stack<>();
            if (root == null) return false;
            stack.push(root);
            sumStack.push(root.val);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                int sum = sumStack.pop();
                if (node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                if (node.left != null) {
                    stack.push(node.left);
                    sumStack.push(sum + node.left.val);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    sumStack.push(sum + node.right.val);
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PathSum_112().new Solution();
        // put your test code here
        
    }
}