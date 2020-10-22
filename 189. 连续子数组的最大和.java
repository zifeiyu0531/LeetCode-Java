// 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

// 要求时间复杂度为O(n)。

//  

// 示例1:

// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//  

// 提示：

// 1 <= arr.length <= 10^5
// -100 <= arr[i] <= 100
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/

class Solution_189 {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(0, nums[i - 1]);
            sum = Math.max(sum, nums[i]);
        }
        return sum;
    }

    public static void main(String args[]) {
        Solution_189 solution = new Solution_189();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solution.maxSubArray(nums));
    }
}