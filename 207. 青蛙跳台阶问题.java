// 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

// 示例 1：

// 输入：n = 2
// 输出：2
// 示例 2：

// 输入：n = 7
// 输出：21
// 示例 3：

// 输入：n = 0
// 输出：1
// 提示：

// 0 <= n <= 100

class Solution_207 {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return (int) dp[n];
    }

    public static void main(String args[]) {
        Solution_207 solution = new Solution_207();
        int n_1 = 2, n_2 = 7, n_3 = 0;
        System.out.println(solution.numWays(n_1));
        System.out.println(solution.numWays(n_2));
        System.out.println(solution.numWays(n_3));
    }
}