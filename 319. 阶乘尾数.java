// 设计一个算法，算出 n 阶乘有多少个尾随零。

// 示例 1:

// 输入: 3
// 输出: 0
// 解释: 3! = 6, 尾数中没有零。
// 示例 2:

// 输入: 5
// 输出: 1
// 解释: 5! = 120, 尾数中有 1 个零.
// 说明: 你算法的时间复杂度应为 O(log n) 。
class Solution_319 {
    public int trailingZeroes(int n) {
        int res = 0;
        for (long num = 5; n / num > 0; num *= 5) {
            res += n / num;
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_319 solution = new Solution_319();
        int n_1 = 3, n_2 = 5;
        System.out.println(solution.trailingZeroes(n_1));
        System.out.println(solution.trailingZeroes(n_2));
    }
}