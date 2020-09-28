package gaopei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question47 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flagArray = new boolean[nums.length];
        trace(nums, result, new ArrayList<>(), 0, flagArray);
        return result;
    }

    private void trace(int[] nums, List<List<Integer>> result, List<Integer> curr, int index, boolean[] flagArray) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flagArray[i] || (i > 0 && nums[i] == nums[i - 1] && !flagArray[i - 1])) {
                continue;
            }
            int value = nums[i];
            curr.add(value);
            flagArray[i] = true;
            trace(nums, result, curr, index + 1, flagArray);
            curr.remove(index);
            flagArray[i] = false;
        }
    }

    public static void main(String[] args) {
        Question47 question46 = new Question47();
        System.out.println(question46.permute(new int[]{1, 1, 2}));
    }
}
