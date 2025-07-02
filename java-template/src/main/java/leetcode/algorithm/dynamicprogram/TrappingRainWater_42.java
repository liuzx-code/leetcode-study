
package leetcode.algorithm.dynamicprogram;

/**
 * 42. 接雨水
 */
public class TrappingRainWater_42 {

    class Solution {

        /**
         * 核心逻辑分点说明：
         * 边界判断：如果输入数组为空或长度为0，直接返回0。
         * 预处理左右最高柱子：
         * leftMax[i] 表示从左到i位置的最大高度；
         * rightMax[i] 表示从右到i位置的最大高度。
         * 计算每个位置能接的水量：每个位置i能接的水为 min(leftMax[i], rightMax[i]) - height[i]。
         * 累加所有位置的储水量，得到最终结果
         * @param height
         * @return
         */
        public int trap(int[] height) {
            if (height == null || height.length == 0) return 0;

            int n = height.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            // 表示从左到i位置的最大高度；
            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            // 表示从右到i位置的最大高度。
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return res;
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater_42().new Solution();
        // put your test code here
        
    }
}