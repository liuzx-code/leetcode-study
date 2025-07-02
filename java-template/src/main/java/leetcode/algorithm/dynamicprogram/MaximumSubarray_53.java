
package leetcode.algorithm.dynamicprogram;

/**
 * 53. 最大子数组和
 */
public class MaximumSubarray_53 {

    class Solution {
        /**
         * 寻找数组中连续子数组的最大和
         * 本方法实现了一个著名的动态规划算法，用于解决最大子数组和问题
         * 它通过迭代数组，计算当前最大子数组和（maxCurrent）和全局最大子数组和（maxGlobal）
         *
         * @param nums 输入的整数数组，不能为空
         * @return 返回整个数组中连续子数组的最大和
         */
        public int maxSubArray(int[] nums) {
            // 初始化当前最大子数组和为第一个元素
            int maxCurrent = nums[0];
            // 初始化全局最大子数组和为第一个元素
            int maxGlobal = nums[0];

            // 从第二个元素开始遍历数组
            for (int i = 1; i < nums.length; i++) {
                // 更新当前最大子数组和，如果加上当前元素后大于当前元素，说明当前元素加入当前子数组是有利的
                maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
                // 更新全局最大子数组和，比较当前全局最大值和当前最大子数组和
                maxGlobal = Math.max(maxGlobal, maxCurrent);
            }

            // 返回全局最大子数组和
            return maxGlobal;
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray_53().new Solution();
        // put your test code here
        
    }
}