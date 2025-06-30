
package leetcode.algorithm.backtrack;

import java.util.*;

/**
 * 78. 子集
 * nums = [1,2,3]
 * [
 *   [],
 *   [1],
 *   [1, 2],
 *   [1, 2, 3],
 *   [1, 3],
 *   [2],
 *   [2, 3],
 *   [3]
 * ]
 */
public class Subsets_78 {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0);
            return res;
        }
        void backtrack(int[] nums, int start) {
            // 前序位置：收集所有节点路径，包括空集
            res.add(new ArrayList<>(path));

            for (int i = start; i < nums.length; i++) {
                // 做选择
                path.add(nums[i]);

                // 进入下一层决策树
                backtrack(nums, i + 1);

                // 撤销选择
                path.removeLast();
            }
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new Subsets_78().new Solution();
        // put your test code here
        
    }
}