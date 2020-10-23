// 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

// 示例1:

//  输入：n = 3 
//  输出：4
//  说明: 有四种走法
// 示例2:

//  输入：n = 5
//  输出：13
// 提示:

// n范围在[1, 1000000]之间

class Solution_191 {
    public int waysToStep(int n) {
        long[] dp = { 1, 2, 4 };
        if (n <= 3) {
            return (int) dp[n - 1];
        }
        for (int i = 4; i <= n; i++) {
            long temp = dp[2];
            dp[2] = (dp[2] + dp[1] + dp[0]) % 1000000007;
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return (int) dp[2];
    }

    public static void main(String args[]) {
        Solution_191 solution = new Solution_191();
        int n_1 = 3, n_2 = 5;
        System.out.println(solution.waysToStep(n_1));
        System.out.println(solution.waysToStep(n_2));
    }
}