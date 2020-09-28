package gaopei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    private void process(int[] candidates, int target, List<List<Integer>> result, List<Integer> currList, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(currList));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int rs = candidates[i] + sum;
            if (rs > target) {
                break;
            }
            currList.add(candidates[i]);
            process(candidates, target, result, currList, rs, i);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question39 question = new Question39();
        System.out.println(question.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(question.combinationSum(new int[]{2, 3, 5}, 8));

    }
}
