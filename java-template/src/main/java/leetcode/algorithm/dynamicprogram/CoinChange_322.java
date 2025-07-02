
package leetcode.algorithm.dynamicprogram;

import java.util.*;

/**
 * 322. 零钱兑换
 */
public class CoinChange_322 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            // dp[i] 表示组成金额 i 所需的最少硬币数
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1); // 初始化为一个较大的值（不可达）
            dp[0] = 0; // 金额 0 所需硬币数为 0

            for (int i = 1; i <= amount; i++) { // 遍历金额
                for (int coin : coins) { // 尝试每种硬币
                    if (i - coin >= 0) { // 金额 >= 硬币面值 存在的情况 不用算出硬币数相加是否等于金额
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }

            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new CoinChange_322().new Solution();
        // put your test code here
        
    }
}