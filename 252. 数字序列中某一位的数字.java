// 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

// 请写一个函数，求任意第n位对应的数字。

//  

// 示例 1：

// 输入：n = 3
// 输出：3
// 示例 2：

// 输入：n = 11
// 输出：0
//  

// 限制：

// 0 <= n < 2^31
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
class Solution_252 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = 9 * digit * start;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String args[]) {
        Solution_252 solution = new Solution_252();
        int n_1 = 3, n_2 = 11;
        System.out.println(solution.findNthDigit(n_1));
        System.out.println(solution.findNthDigit(n_2));
    }
}