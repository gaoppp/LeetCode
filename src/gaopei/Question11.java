package gaopei;

public class Question11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Question11 question = new Question11();
        System.out.println(question.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
