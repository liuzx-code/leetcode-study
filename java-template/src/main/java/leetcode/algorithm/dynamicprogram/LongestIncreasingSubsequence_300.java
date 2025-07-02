
package leetcode.algorithm.dynamicprogram;

import java.util.*;

/**
 * 300. 最长递增子序列
 */
public class LongestIncreasingSubsequence_300 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int n = nums.length;
            int[] dp = new int[n];
            // 每个元素本身至少是一个长度为1的子序列
            // 为了计算长度
            Arrays.fill(dp, 1);

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            // 找出dp数组中的最大值
            int max = 1;
            for (int len : dp) {
                max = Math.max(max, len);
            }

            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence_300().new Solution();
        // put your test code here
        
    }
}