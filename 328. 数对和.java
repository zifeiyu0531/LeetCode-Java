import java.util.*;

// 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。

// 示例 1:

// 输入: nums = [5,6,5], target = 11
// 输出: [[5,6]]
// 示例 2:

// 输入: nums = [5,6,5,6], target = 11
// 输出: [[5,6],[5,6]]
// 提示：

// nums.length <= 100000
class Solution_328 {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        if (nums.length < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int num1 = nums[left], num2 = nums[right];
            if (num1 + num2 == target) {
                Integer[] arr = { num1, num2 };
                res.add(Arrays.asList(arr));
                left++;
                right--;
            } else if (num1 + num2 > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_328 solution = new Solution_328();
        int[] nums_1 = { 5, 6, 5 }, nums_2 = { 5, 6, 5, 6 };
        int target_1 = 11, target_2 = 11;
        System.out.println(solution.pairSums(nums_1, target_1).toString());
        System.out.println(solution.pairSums(nums_2, target_2).toString());
    }
}