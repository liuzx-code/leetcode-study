package leetcode.algorithm.string;


/**
 * @author jiangyinsuo
 * @date 2025/6/19 17:25
 * @Description:大数加法_牛客题霸_牛客网
 * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=196&tqId=37176&ru=/exam/oj
 *
 * 描述
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * 输入： "1","99"
 * 返回值："100"
 * 说明： 1+99=100
 *
 */
public class BigDataAdd_牛客 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                // 将字符转换为数字
                // 为什么是 减去'0'？ 因为 '0' 的 ASCII 码是 48，所以 '0' - '0' = 0
                sum += s.charAt(i--) - '0';
            }

            if (j >= 0) {
                // 将字符转换为数字
                sum += t.charAt(j--) - '0';
            }
            // 进位
            carry = sum / 10;
            // 当前位
            result.append(sum % 10);
        }

        // 反转得到正确顺序
        return result.reverse().toString();
    }

}
