// 给定一个整数数组，找出总和最大的连续数列，并返回总和。

// 示例：

// 输入： [-2,1,-3,4,-1,2,1,-5,4]
// 输出： 6
// 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 进阶：

// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

class Solution_192 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int dp = nums[0], max = dp;
        for (int i = 1; i < n; i++) {
            dp = Math.max(dp, 0) + nums[i];
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String args[]) {
        Solution_192 solution = new Solution_192();
        int[] nums_1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solution.maxSubArray(nums_1));
    }
}