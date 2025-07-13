package leetcode.algorithm.hash;

import java.util.*;

/**
 * 49. 字母异位词分组(含有相同的字母可能顺序不一样组合在一起)
 */
public class GroupAnagrams_49 {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<List<String >>(map.values());
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams_49().new Solution();
        // put your test code here
        
    }
}