// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

// 示例 1:

// 输入: 121
// 输出: true
// 示例 2:

// 输入: -121
// 输出: false
// 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 示例 3:

// 输入: 10
// 输出: false
// 解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 进阶:

// 你能不将整数转为字符串来解决这个问题吗？

class Solution_52 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            return x == revertedNumber || revertedNumber / 10 == x;
        }
    }

    public static void main(String args[]) {
        Solution_52 solution = new Solution_52();
        int x_1 = 121, x_2 = -121, x_3 = 10;
        System.out.println(solution.isPalindrome(x_1));
        System.out.println(solution.isPalindrome(x_2));
        System.out.println(solution.isPalindrome(x_3));
    }
}