
package leetcode.algorithm.backtrack;

import java.util.*;

/**
 * 90. 子集 II
 */
public class SubsetsIi_90 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums); // 排序，使相同元素相邻
            backtrack(nums, 0);
            return res;
        }

        void backtrack(int[] nums, int start) {
            res.add(new ArrayList<>(path));

            for (int i = start; i < nums.length; i++) {
                // 剪枝：同一层中，若当前元素和前一个相同且前一个未选，则跳过
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }

                // 做选择
                path.add(nums[i]);
                // 进入下一层
                backtrack(nums, i + 1);
                // 撤销选择
                path.removeLast();
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SubsetsIi_90().new Solution();
        // put your test code here
        
    }
}