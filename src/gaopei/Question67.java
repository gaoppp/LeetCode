package gaopei;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question67 {
    public String addBinary(String a, String b) {
        String res = "";
        int n = a.length() - 1;
        int m = b.length() - 1;
        int flag = 0;
        while (n >= 0 || m >= 0) {
            int num1 = n >= 0 ? a.charAt(n) - '0' : 0;
            int num2 = m >= 0 ? b.charAt(m) - '0' : 0;

            int sum = num1 + num2 + flag;
            flag = sum / 2;
            res = (sum % 2) + res;
            n--;
            m--;
        }
        if (flag != 0) {
            res = flag + res;
        }
        return res;
    }
}
