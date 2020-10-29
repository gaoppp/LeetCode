package gaopei;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question34 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{0, 0};
        }
        int right = findRight(nums, target);
        int left = findLeft(nums, target);
        return new int[]{left, right};
    }

    private static int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                left = mid + 1;
            } else if (num > target) {
                right = mid - 1;
            } else if (num < target) {
                left = mid + 1;
            }
        }

        // 最后要检查 left 越界的情况
        if (right <0 || nums[right] != target)
            return -1;
        return right;
    }

    private static int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                right = mid - 1;
            } else if (num > target) {
                right = mid - 1;
            } else if (num < target) {
                left = mid + 1;
            }
        }

        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 0)));
    }
}
