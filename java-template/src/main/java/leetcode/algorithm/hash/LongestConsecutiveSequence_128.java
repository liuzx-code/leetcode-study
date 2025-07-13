package leetcode.algorithm.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列（在乱序中找到连续的长度）
 */
public class LongestConsecutiveSequence_128 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int longestStreak = 0;
            for (int num : set) {
                // 不包含说明不是连续的所以得更新长度
                if (!set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;
                    // 找到连续的,往后继续计数
                    while (set.contains(currentNum + 1)) {
                        currentNum++;
                        currentStreak++;
                    }
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
            return longestStreak;
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence_128().new Solution();
        // put your test code here
        
    }
}