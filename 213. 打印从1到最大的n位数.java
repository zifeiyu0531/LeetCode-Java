import java.util.*;

// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

// 示例 1:

// 输入: n = 1
// 输出: [1,2,3,4,5,6,7,8,9]
//  

// 说明：

// 用返回一个整数列表来代替打印
// n 为正整数

class Solution_213 {
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    public static void main(String args[]) {
        Solution_213 solution = new Solution_213();
        int n = 1;
        System.out.println(Arrays.toString(solution.printNumbers(n)));
    }
}