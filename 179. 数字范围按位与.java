// 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

// 示例 1: 

// 输入: [5,7]
// 输出: 4
// 示例 2:

// 输入: [0,1]
// 输出: 0

class Solution_179 {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }

    public static void main(String args[]) {
        Solution_179 solution = new Solution_179();
        int m_1 = 5, m_2 = 0;
        int n_1 = 7, n_2 = 1;
        System.out.println(solution.rangeBitwiseAnd(m_1, n_1));
        System.out.println(solution.rangeBitwiseAnd(m_2, n_2));
    }
}