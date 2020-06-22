import java.util.Arrays;

// 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

//  

// 示例：

// 输入：nums = [-1,2,1,-4], target = 1
// 输出：2
// 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//  

// 提示：

// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4

class Solution_40 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length; first++) {
            int second = first + 1, third = nums.length - 1;
            while (second < third) {
                int temp = nums[first] + nums[second] + nums[third];
                if (Math.abs(temp - target) < Math.abs(res - target)) {
                    res = temp;
                }
                if (temp == target) {
                    return res;
                } else if (temp > target) {
                    third--;
                } else {
                    second++;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_40 solution = new Solution_40();
        int[] nums_1 = { -1, 2, 1, -4 };
        int target_1 = 1;
        System.out.println(solution.threeSumClosest(nums_1, target_1));
    }
}