// 给定一个整数 n，返回 n! 结果尾数中零的数量。

// 示例 1:

// 输入: 3
// 输出: 0
// 解释: 3! = 6, 尾数中没有零。
// 示例 2:

// 输入: 5
// 输出: 1
// 解释: 5! = 120, 尾数中有 1 个零.
// 说明: 你算法的时间复杂度应为 O(log n) 。

class Solution_169 {
    public int trailingZeroes(int n) {
        int nums = 0;
        int div = 5;
        while (n >= div) {
            nums += n / div;
            div *= 5;
        }
        return nums;
    }

    public static void main(String args[]) {
        Solution_169 solution = new Solution_169();
        int n_1 = 3, n_2 = 5;
        System.out.println(solution.trailingZeroes(n_1));
        System.out.println(solution.trailingZeroes(n_2));
    }
}