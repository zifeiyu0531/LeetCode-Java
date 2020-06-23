// 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

// 返回被除数 dividend 除以除数 divisor 得到的商。

// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

//  

// 示例 1:

// 输入: dividend = 10, divisor = 3
// 输出: 3
// 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
// 示例 2:

// 输入: dividend = 7, divisor = -3
// 输出: -2
// 解释: 7/-3 = truncate(-2.33333..) = -2
//  

// 提示：

// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

class Solution_47 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        long ans = 0, dividend_long = dividend, divisor_long = divisor;
        boolean ispos = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            ispos = false;
        }
        dividend_long = Math.abs(dividend_long);
        divisor_long = Math.abs(divisor_long);
        ans = div(dividend_long, divisor_long);
        ans = Math.min(ans, Integer.MAX_VALUE);
        if (!ispos) {
            ans = -ans;
        }
        return (int) ans;
    }

    public long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            count += count;
            tb += tb;
        }
        return count + div(a - tb, b);
    }

    public static void main(String args[]) {
        Solution_47 solution = new Solution_47();
        int dividend_1 = 10, dividend_2 = 7;
        int divisor_1 = 3, divisor_2 = -3;
        System.out.println(solution.divide(dividend_1, divisor_1));
        System.out.println(solution.divide(dividend_2, divisor_2));
    }
}