// 实现 int sqrt(int x) 函数。

// 计算并返回 x 的平方根，其中 x 是非负整数。

// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

// 示例 1:

// 输入: 4
// 输出: 2
// 示例 2:

// 输入: 8
// 输出: 2
// 说明: 8 的平方根是 2.82842..., 
//      由于返回类型是整数，小数部分将被舍去。

class Solution_85 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String args[]) {
        Solution_85 solution = new Solution_85();
        int x_1 = 4, x_2 = 8;
        System.out.println(solution.mySqrt(x_1));
        System.out.println(solution.mySqrt(x_2));
    }
}