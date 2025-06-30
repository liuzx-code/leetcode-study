
package leetcode.algorithm.backtrack;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class PermutationsIi_47 {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums); // 排序用于剪枝， 对 nums 排序，使相同元素相邻
            LinkedList<Integer> track = new LinkedList<>();// 记录「路径」
            boolean[] used = new boolean[nums.length];// 「路径」中的元素会被标记为 true，避免重复使用
            backtrack(nums, track, used);
            return res;
        }

        void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) { // 排除不合法的选择,nums[i] 已经在 track 中，跳过
                    continue;
                }
                // 剪枝：同一层决策树中，跳过重复元素
                // 同一层中，若当前元素与前一个相同且前一个未使用，则跳过，防止重复排列
                // 防止 第二次先选了第二个 1，再选第一个 1 → 也得到 [1,1,2]
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                used[i] = true;
                // 进入下一层决策树
                backtrack(nums, track, used);
                // 取消选择
                track.removeLast();
                used[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PermutationsIi_47().new Solution();
        // put your test code here
        
    }
}