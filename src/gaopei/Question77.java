package gaopei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        Stack<Integer> queue = new Stack<>();
        dfs(n, k, 1, queue, result);
        return result;
    }

    public void dfs(int n, int k, int start, Stack<Integer> queue, List<List<Integer>> result) {
        if (queue.size() == k) {
            result.add(new ArrayList<>(queue));
            return;
        }
        for (int i = start; i <= n - (k - queue.size()) + 1; i++) {
            queue.add(i);
            dfs(n, k, i + 1, queue, result);
            queue.pop();
        }
    }

    public static void main(String[] args) {
        Question77 question = new Question77();
        System.out.println(question.combine(4, 2));
    }
}
