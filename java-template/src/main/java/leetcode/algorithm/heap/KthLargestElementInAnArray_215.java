package leetcode.algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215 . 数组中的第K个最大元素
 */
public class KthLargestElementInAnArray_215 {

    class Solution {
        /**
         * 方式一：
         */
        public int findKthLargest1(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
        /**
         * 方式二：
         */
        public int findKthLargest(int[] nums, int k) {
           // 使用小顶堆  会自动排序 堆顶是最小元素
           PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.offer(num);
                // 堆的大小不能超过k
                if (queue.size() > k) {
                    // 弹出最小的元素
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray_215().new Solution();
        // put your test code here
        
    }
}