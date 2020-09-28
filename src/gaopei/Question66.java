package gaopei;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question66 {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int retain = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i];
            if (num < 9) {
                digits[i] = num + retain;
                return digits;
            }
            // 进位
            digits[i] = 0;
            retain = 1;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Question66 question = new Question66();
        System.out.println(Arrays.toString(question.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(question.plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(question.plusOne(new int[]{9, 9, 9})));

    }
}
