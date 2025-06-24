
package leetcode.algorithm.stack;

import java.util.*;

/**
 * 20. 有效的括号
 */
public class ValidParentheses_20 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                // 判断是否是左括号 如果是就入栈
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                // 如果是右括号就找到最近的左括号
                else {
                    if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
            // 如果全部出栈匹配了，栈应该为空！！！
            return stack.isEmpty();
        }

        char leftOf(char c) {
            if (c == '}') return '{';
            if (c == ')') return '(';
            return '[';
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidParentheses_20().new Solution();
        // put your test code here
        
    }
}