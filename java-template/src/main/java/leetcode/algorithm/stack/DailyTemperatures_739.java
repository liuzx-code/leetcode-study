
package leetcode.algorithm.stack;

import java.util.*;

/**
 * 739 . 每日温度(找右边第一个出现比它高的温度)
 */
public class DailyTemperatures_739 {

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = temperatures.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                // stack.peek() - i 是计算 当前温度之后，第一个更高温度出现的天数差
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
                stack.push(i);
            }
            return res;
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures_739().new Solution();
        // put your test code here
        
    }
}