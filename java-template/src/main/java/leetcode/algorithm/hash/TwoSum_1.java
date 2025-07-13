package leetcode.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 */
public class TwoSum_1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new TwoSum_1().new Solution();
        // put your test code here
        
    }
}