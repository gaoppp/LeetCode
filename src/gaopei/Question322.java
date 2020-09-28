package gaopei;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = dp[i];
            for (int coin : coins) {
                if (coin <= i) {
                    int curr = dp[i - coin];
                    if (curr != -1 && (min == -1 || curr + 1 < min)) {
                        min = curr + 1;
                    }
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        return coinChange1(coins, amount, 0, new int[amount]);
    }

    public int coinChange1(int[] coins, int amount, int curr, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return curr;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int minCount = -1;
        for (int coin : coins) {
            int c = coinChange1(coins, amount - coin, curr + 1, count);
            if (c != -1 && (minCount == -1 || c < minCount)) {
                minCount = c;
            }
        }
        count[amount - 1] = minCount;
        return minCount;
    }

    public static void main(String[] args) {
        Question322 question = new Question322();
        System.out.println(question.coinChange(new int[]{2}, 3));
        System.out.println(question.coinChange(new int[]{1, 2, 5}, 11));

    }
}
