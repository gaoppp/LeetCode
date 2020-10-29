package gaopei;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        process(n, 0, 0, "", result);
        return result;
    }


    public void process(int n, int rightNum, int leftNum, String str, List<String> result) {
        if (rightNum == n && leftNum == n) {
            result.add(str);
            return;
        }
        if (leftNum < n) {
            process(n, rightNum, leftNum + 1, str + "(", result);
        }
        if (rightNum < n && rightNum < leftNum) {
            process(n, rightNum + 1, leftNum, str + ")", result);
        }
    }
}
