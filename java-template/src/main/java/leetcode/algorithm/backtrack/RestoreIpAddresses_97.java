
package leetcode.algorithm.backtrack;

import java.util.*;

/**
 * 97 . 复原 IP 地址
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 */
public class RestoreIpAddresses_97 {

    class Solution {
        public List<String> restoreIpAddresses(java.lang.String s) {
            List<String> result = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return result;
            }
            backtrack(s, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(String s, int start, List<String> path, List<String> result) {
            if (path.size() == 4) {
                if (start == s.length()) {
                    result.add(String.join(".", path));
                }
                return;
            }

            for (int length = 1; length <= 3; length++) {
                if (start + length > s.length()) {
                    break;
                }
                String segment = s.substring(start, start + length);
                if (isValid(segment)) {
                    path.add(segment);
                    backtrack(s, start + length, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isValid(String segment) {
            if (segment.startsWith("0") && segment.length() > 1) {
                return false; // 前导零不合法
            }
            int value = Integer.parseInt(segment);
            return value >= 0 && value <= 255;
        }
    }

    
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses_97().new Solution();
        // put your test code here
        
    }
}