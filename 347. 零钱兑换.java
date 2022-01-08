import java.util.Arrays;

// 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

// 你可以认为每种硬币的数量是无限的。

//  

// 示例 1：

// 输入：coins = [1, 2, 5], amount = 11
// 输出：3 
// 解释：11 = 5 + 5 + 1
// 示例 2：

// 输入：coins = [2], amount = 3
// 输出：-1
// 示例 3：

// 输入：coins = [1], amount = 0
// 输出：0
// 示例 4：

// 输入：coins = [1], amount = 1
// 输出：1
// 示例 5：

// 输入：coins = [1], amount = 2
// 输出：2
//  

// 提示：

// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
class Solution_347 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String args[]) {
        Solution_347 solution = new Solution_347();
        int[] coins_1 = { 1, 2, 5 }, coins_2 = { 2 }, coins_3 = { 1 }, coins_4 = { 1 }, coins_5 = { 1 };
        int amount_1 = 11, amount_2 = 3, amount_3 = 0, amount_4 = 1, amount_5 = 2;
        System.out.println(solution.coinChange(coins_1, amount_1));
        System.out.println(solution.coinChange(coins_2, amount_2));
        System.out.println(solution.coinChange(coins_3, amount_3));
        System.out.println(solution.coinChange(coins_4, amount_4));
        System.out.println(solution.coinChange(coins_5, amount_5));
    }
}