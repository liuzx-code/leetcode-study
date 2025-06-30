
package leetcode.algorithm.backtrack;

import java.util.*;

/**
 * 39.组合总和
 * 输入：candidates = [2,3,6,7],
 * target = 7
 * 输出：[[2,2,3],[7]]
 */
public class CombinationSum_39 {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates); // 排序，便于后续剪枝
            backtrack(candidates, target, 0);
            return res;
        }

        void backtrack(int[] candidates, int target, int start) {
            if (target == 0) {
                res.add(new ArrayList<>(path)); // 找到一个有效组合
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                int num = candidates[i];
                if (num > target) break; // 剪枝：超出目标值，直接结束循环

                path.add(num); // 做选择
                backtrack(candidates, target - num, i); // 可以重复选当前元素，所以下一层从 i 开始
                path.removeLast(); // 撤销选择
            }
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new CombinationSum_39().new Solution();
        // put your test code here
        
    }
}