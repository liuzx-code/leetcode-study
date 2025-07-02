
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
                        // 当金额 = 硬币面值时，硬币数就是 1 所以得加1 不然最少硬币就为0了
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            // 最坏情况下，假设每枚硬币面值为 1，最多需要 amount 枚硬币。
            // amount + 1 是一个较大的值，表示无法组成总金额。
            // 相当于 if (dp[amount] == amount + 1) return -1;
            // 如果没有任何一种硬币组合能组成总金额，返回 -1 。
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new CoinChange_322().new Solution();
        // put your test code here
        
    }
}