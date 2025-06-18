package leetcode.algorithm.array;


/**
 * @author liuzx
 * @date 2025/6/18 14:12
 * @Description: 189 轮转数组
 */
public class RotateArray_189 {


    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 边界情况处理
        if (n == 0 || k % n == 0) return;
        //比如 k = 7 n = 7 轮转结果是一样的
        // 或者 k = 14 n = 7 轮转结果是一样的
        k = k % n; // 归一化 k


        // 第一步：翻转整个数组
        reverse(nums, 0, n - 1);
        // 第二步：翻转前 k 个元素
        reverse(nums, 0, k - 1);
        // 第三步：翻转剩余元素
        reverse(nums, k, n - 1);
    }

    /**
     * 辅助方法：翻转数组中从 start 到 end 的部分
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
