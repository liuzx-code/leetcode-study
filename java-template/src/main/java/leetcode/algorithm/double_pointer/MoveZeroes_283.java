package leetcode.algorithm.double_pointer;

/**
 * 283. 移动零
 * 每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
 */
public class MoveZeroes_283 {

    class Solution {
        public void moveZeroes(int[] nums) {
            // 左指针指向的是零的索引
            int n = nums.length,left = 0, right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }
        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new MoveZeroes_283().new Solution();
        // put your test code here
        
    }
}