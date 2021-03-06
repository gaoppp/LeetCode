package gaopei;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question6 {

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows < 2) {
            return s;
        }

        List<StringBuilder> chars = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            chars.add(new StringBuilder());
        }

        int index = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars.get(index).append(c);
            if (index == numRows - 1 || index == 0) {
                flag = !flag;
            }
            index = flag ? index + 1 : index - 1;
        }

        StringBuilder stringBuilder = chars.get(0);
        for (int i = 1; i < chars.size(); i++) {
            stringBuilder.append(chars.get(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Question6 question = new Question6();
        System.out.println(question.convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(question.convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN"));

    }
}
