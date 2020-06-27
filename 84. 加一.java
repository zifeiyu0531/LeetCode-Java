import java.util.*;

// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

// 你可以假设除了整数 0 之外，这个整数不会以零开头。

// 示例 1:

// 输入: [1,2,3]
// 输出: [1,2,4]
// 解释: 输入数组表示数字 123。
// 示例 2:

// 输入: [4,3,2,1]
// 输出: [4,3,2,2]
// 解释: 输入数组表示数字 4321。

class Solution_84 {
    public int[] plusOne(int[] digits) {
        int load = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = 0;
            if (i == digits.length - 1) {
                temp = digits[i] + 1;
            } else {
                temp = digits[i] + load;
            }
            load = temp / 10;
            digits[i] = temp % 10;
            if (load == 0) {
                return digits;
            }
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = digits[i - 1];
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution_84 solution = new Solution_84();
        int[] digits_1 = { 1, 2, 3 }, digits_2 = { 4, 3, 2, 1 };
        System.out.println(Arrays.toString(solution.plusOne(digits_1)));
        System.out.println(Arrays.toString(solution.plusOne(digits_2)));
    }
}