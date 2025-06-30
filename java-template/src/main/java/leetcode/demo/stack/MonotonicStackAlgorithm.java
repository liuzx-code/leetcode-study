package leetcode.demo.stack;

import java.util.Stack;

/**
 *
 * 单调栈算法-总结
 */
public class MonotonicStackAlgorithm {

    /**
     * 只能找右边下一个元素的比它大的
     * @param nums
     * @return
     */
    int[] calculateGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                // 右边比左边的低 就不要了
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

}
