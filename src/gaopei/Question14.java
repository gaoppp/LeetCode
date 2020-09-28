package gaopei;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (true) {
            Character c = null;
            for (String s : strs) {
                if (i >= s.length()) {
                    return builder.toString();
                }
                if (c == null) {
                    c = s.charAt(i);
                } else if (s.charAt(i) != c) {
                    return builder.toString();
                }
            }
            builder.append(c);
            i++;
        }
    }

    public static void main(String[] args) {
        Question14 question14 = new Question14();
        System.out.println(question14.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(question14.longestCommonPrefix(new String[]{"flower","flow","flight"}));

    }
}
