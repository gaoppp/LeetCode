package gaopei;

import java.util.Arrays;

public class Question26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Question26 question = new Question26();
        int[] r = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(question.removeDuplicates(r));
        System.out.println(Arrays.toString(r));

    }
}
