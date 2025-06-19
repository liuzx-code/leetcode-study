package leetcode.algorithm.string;


import java.util.HashMap;

/**
 * @author liuzx
 * @date 2025/6/19 17:03
 * @Description: 3. 无重复字符的最长子串
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    /**
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // s = "abcabcbb"
        // 创建一个哈希表用于存储字符及其最后出现的位置
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // 如果字符已存在于窗口中，则移动左指针到该字符上次出现位置的右侧
            //  charIndexMap.get(currentChar) >= start 的作用是为了确保当前字符的上一次出现的位置在滑动窗口的起始位置或其左侧
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }

            // 更新字符的最新位置
            charIndexMap.put(currentChar, end);

            // 计算当前窗口长度并更新最大值
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
