package gaopei;

public class Question28 {

    /**
     * 实现 strStr() 函数。
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     * <p>
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int out = 0;
        int in = 0;
        while (out < haystack.length()) {
            if (in > 0 && in ==  needle.length()) {
                return out;
            }
            if (out + in + 1 > haystack.length()) {
                return -1;
            }
            if (haystack.charAt(out + in) == needle.charAt(in)) {
                in++;
            } else {
                out++;
                in = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question28 question = new Question28();
        System.out.println(question.strStr("aaa", "a"));
        System.out.println(question.strStr("a", "aaaa"));
        System.out.println(question.strStr("aaa", "aaaa"));
        System.out.println(question.strStr("ccc", "q"));
        System.out.println(question.strStr("a", "a"));
        System.out.println(question.strStr("hello", "ll"));
        System.out.println(question.strStr("aaaaa", "bba"));
    }
}
