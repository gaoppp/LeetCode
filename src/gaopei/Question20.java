package gaopei;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Question20 {

    private static Map<Character, Character> PAIR_MAP = new HashMap<>();

    static {
        PAIR_MAP.put(')', '(');
        PAIR_MAP.put('}', '{');
        PAIR_MAP.put(']', '[');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            Character pair = PAIR_MAP.get(c);
            if (pair == null) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || stack.pop() != pair) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Question20 question20 = new Question20();
        assert question20.isValid("()");
        assert question20.isValid("()[]{}");
        assert !question20.isValid("([)]");
        assert question20.isValid("{[]}");
        assert !question20.isValid("{[");
        assert !question20.isValid("]");
        System.out.println(question20.isValid("[]"));
    }
}
