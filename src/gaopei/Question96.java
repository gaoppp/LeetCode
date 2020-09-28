package gaopei;

public class Question96 {

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] state = new int[n + 1];
        state[0] = 1;
        state[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                state[i] += state[j - 1] * state[i - j];
            }
        }
        return state[n];
    }

    public int numTrees1(int n) {
        if (n < 1) {
            return 0;
        }
        return numTrees(n, 1, n);
    }

    public int numTrees(int n, int min, int max) {
        if (min == max) {
            return 1;
        }
        int count = 0;
        for (int i = min; i <= max; i++) {
            int right = 1;
            if (i > min) {
                right = numTrees(n, min, i - 1);
            }
            int left = 1;
            if (i < max) {
                left = numTrees(n, i + 1, max);
            }
            count += right * left;
        }
        return count;
    }

    public static void main(String[] args) {
        Question96 question = new Question96();
        System.out.println(question.numTrees(3));
    }
}
