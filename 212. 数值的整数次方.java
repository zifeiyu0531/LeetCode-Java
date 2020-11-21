// 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

//  

// 示例 1:

// 输入: 2.00000, 10
// 输出: 1024.00000
// 示例 2:

// 输入: 2.10000, 3
// 输出: 9.26100
// 示例 3:

// 输入: 2.00000, -2
// 输出: 0.25000
// 解释: 2-2 = 1/22 = 1/4 = 0.25
//  

// 说明:

// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

class Solution_212 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_212 solution = new Solution_212();
        double x_1 = 2, x_2 = 2.1, x_3 = 2;
        int n_1 = 10, n_2 = 3, n_3 = -2;
        System.out.println(solution.myPow(x_1, n_1));
        System.out.println(solution.myPow(x_2, n_2));
        System.out.println(solution.myPow(x_3, n_3));
    }
}