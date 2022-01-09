// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

//  

// 示例 1：

// 输入：nums = [1,5,11,5]
// 输出：true
// 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
// 示例 2：

// 输入：nums = [1,2,3,5]
// 输出：false
// 解释：数组不能分割成两个元素和相等的子集。
//  

// 提示：

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
class Solution_352 {
    public boolean canPartition(int[] nums) {
        int sumValue = 0, maxValue = 0;
        for (int num : nums) {
            sumValue += num;
            maxValue = Math.max(maxValue, num);
        }
        if (sumValue % 2 != 0) {
            return false;
        }
        int target = sumValue / 2;
        if (maxValue > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] |= dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main(String args[]) {
        Solution_352 solution = new Solution_352();
        int[] nums_1 = { 1, 5, 11, 5 }, nums_2 = { 1, 2, 3, 5 };
        System.out.println(solution.canPartition(nums_1));
        System.out.println(solution.canPartition(nums_2));
    }
}