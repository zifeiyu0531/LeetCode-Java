import java.util.*;

// 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

//  

// 示例:

// 输入: n = 10
// 输出: 12
// 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
// 说明:  

// 1 是丑数。
// n 不超过1690。
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
class Solution_257 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        for (int i = 1; i < n; i++) {
            int num1 = dp[idx1] * 2, num2 = dp[idx2] * 3, num3 = dp[idx3] * 5;
            int next = Math.min(num1, Math.min(num2, num3));
            dp[i] = next;
            if (next == num1) {
                idx1++;
            }
            if (next == num2) {
                idx2++;
            }
            if (next == num3) {
                idx3++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String args[]) {
        Solution_257 solution = new Solution_257();
        int n = 10;
        System.out.println(solution.nthUglyNumber(n));
    }
}