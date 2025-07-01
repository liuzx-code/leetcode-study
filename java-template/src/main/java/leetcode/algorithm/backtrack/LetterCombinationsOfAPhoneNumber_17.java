
package leetcode.algorithm.backtrack;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber_17 {

    class Solution {
        private Map<Character, String> digitToLetters = new HashMap<>();
        private List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return result;
            }

            digitToLetters.put('2', "abc");
            digitToLetters.put('3', "def");
            digitToLetters.put('4', "ghi");
            digitToLetters.put('5', "jkl");
            digitToLetters.put('6', "mno");
            digitToLetters.put('7', "pqrs");
            digitToLetters.put('8', "tuv");
            digitToLetters.put('9', "wxyz");

            backtrack(digits, 0, new StringBuilder());
            return result;
        }

        /**
         * 使用回溯法处理字符串数字的字母组合
         *
         * @param digits 输入的数字字符串
         * @param index 当前处理的数字字符的索引
         * @param current 当前构建的字母组合
         */
        private void backtrack(String digits, int index, StringBuilder current) {
            // 如果当前索引等于数字字符串的长度，说明已经遍历到最后一个数字字符，将当前构建的字符串添加到结果中
            if (index == digits.length()) {
                result.add(current.toString());
                return;
            }

            // 获取当前数字字符对应的字母字符串
            String letters = digitToLetters.get(digits.charAt(index));
            // 遍历当前数字字符对应的每个字母
            for (char ch : letters.toCharArray()) {
                // 将字母添加到当前构建的字符串中
                current.append(ch);
                // 递归调用backtrack函数，处理下一个数字字符
                backtrack(digits, index + 1, current);
                // 回溯，移除当前构建的字符串的最后一个字母，尝试下一个字母组合
                current.deleteCharAt(current.length() - 1);
            }
        }

    }

    
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber_17().new Solution();
        // put your test code here
        
    }
}