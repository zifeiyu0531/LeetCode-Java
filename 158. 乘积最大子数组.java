// 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

//  

// 示例 1:

// 输入: [2,3,-2,4]
// 输出: 6
// 解释: 子数组 [2,3] 有最大乘积 6。
// 示例 2:

// 输入: [-2,0,-1]
// 输出: 0
// 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

class Solution_158 {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int m = max, n = min;
            max = Math.max(m * nums[i], Math.max(nums[i], n * nums[i]));
            min = Math.min(n * nums[i], Math.min(nums[i], m * nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution_158 solution = new Solution_158();
        int[] nums_1 = { 2, 3, -2, 4 }, nums_2 = { -2, 0, -1 };
        System.out.println(solution.maxProduct(nums_1));
        System.out.println(solution.maxProduct(nums_2));
    }
}