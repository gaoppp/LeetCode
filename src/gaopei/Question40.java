package gaopei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        process(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    /**
     * flag的作用：防止同一元素重复取
     */
    private void process(int[] candidates, int target, List<List<Integer>> result, List<Integer> currList, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(currList));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1] ) {
                // 避免重复结果
                continue;
            }
            int rs = candidates[i] + sum;
            if (rs > target) {
                break;
            }
            currList.add(candidates[i]);
            process(candidates, target, result, currList, rs, i+1);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question40 question = new Question40();
        System.out.println(question.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(question.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));

    }
}
