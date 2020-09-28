package gaopei;

import java.util.ArrayList;
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
public class Question46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        trace(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void trace(int[] nums, List<List<Integer>> result, List<Integer> curr, int index) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (curr.contains(value)) {
                continue;
            }
            curr.add(value);
            trace(nums, result, curr, index + 1);
            curr.remove(index);
        }
    }

    public static void main(String[] args) {
        Question46 question46 = new Question46();
        System.out.println(question46.permute(new int[]{1, 2, 3}));
    }
}
