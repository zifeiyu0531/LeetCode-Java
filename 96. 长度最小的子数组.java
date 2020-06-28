// 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

// 示例: 

// 输入: s = 7, nums = [2,3,1,2,4,3]
// 输出: 2
// 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 进阶:

// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

class Solution_96 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                len = Math.min(len, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String args[]) {
        Solution_96 solution = new Solution_96();
        int s = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(solution.minSubArrayLen(s, nums));
    }
}