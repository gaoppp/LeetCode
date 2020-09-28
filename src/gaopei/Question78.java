package gaopei;

import java.util.ArrayList;
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
public class Question78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        process(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void process(int[] nums, List<List<Integer>> result, List<Integer> currList, int startIndex) {
        result.add(new ArrayList<>(currList));
        if (currList.size() == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            currList.add(nums[i]);
            process(nums, result, currList, i + 1);
            currList.remove(currList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question78 question = new Question78();
        System.out.println(question.subsets(new int[]{1, 2, 3}));

    }
}
