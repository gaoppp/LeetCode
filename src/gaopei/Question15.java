package gaopei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Question15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int curr = nums[left] + nums[right];
                if (curr == target) {
                    List<Integer> one = new ArrayList<>();
                    one.add(nums[i]);
                    one.add(nums[left]);
                    one.add(nums[right]);
                    result.add(one);
                    left++;
                    right--;
                    continue;
                }
                if (curr < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Question15 question15 = new Question15();
        System.out.println(question15.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }

}
